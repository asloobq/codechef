import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//FireER
public class Main {

	static BufferedReader br;
	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = 0;
		
		try {
			String line = br.readLine();
			testCases = Integer.parseInt(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int testIndex =0; testIndex < testCases; testIndex++) {
			//read line to get no of members and relationships
			int members, relations;
			String line;
			try {
				line = br.readLine();
				//System.out.println("" + line);
				members = Integer.parseInt(line.substring(0, line.indexOf(" ")));
				relations = Integer.parseInt(line.substring(line.indexOf(" ")+1));
				readRelations(members, relations);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	static void readRelations(final int members, int relationCount) {
		//read relations
		int arr[][] = new int[relationCount][2];
		for(int relIndex = 0; relIndex < relationCount; relIndex++) {
			String line;
			try {
				line = br.readLine();
				//System.out.println("" + line);
				arr[relIndex][0]= Integer.parseInt(line.substring(0, line.indexOf(" ")));
				arr[relIndex][1] = Integer.parseInt(line.substring(line.indexOf(" ")+1));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		int routes = getMaxRoutes(members, arr, relationCount);
//		System.out.println("max routes = " + routes);
	}
	
	static int getMaxRoutes(int members, int relations[][], int relationCount) {
		//if no relationsships the each one has separate fire escape rooute
		if(relationCount == 0) {
			return members;
		}
			
		int maxRoutes = 0;
		//boolean processedMemArr[][] = new boolean[members][members];
		boolean processedMemArr[] = new boolean[members];
		//initialise to false
		for(boolean mem: processedMemArr) {
			mem = false;
		}
		int currentRouteNo = 1;
		int memberRouteArr[] = new int[members];
//		for(int i = 0; i < members; i++) {
//			for(int j = 0; j < members; j++) {
//				processedMemArr[i][j] = false;
//			}
//		}
		//for a relationship between two members ->add them to processed list and increment routes
		for(int index = 0; index < relationCount;index++) {
			//get number
			int friend1 = relations[index][0];
			int friend2 = relations[index][1];
			//check if already in list
			if ((!processedMemArr[friend1-1]) && (!processedMemArr[friend2-1])) {
				//both have not been added increment routes
				//create new route for them
				memberRouteArr[friend1 -1] = currentRouteNo;
				memberRouteArr[friend2 -1] = currentRouteNo;				
				maxRoutes++;			
				currentRouteNo++;
			} else if ((processedMemArr[friend1-1]) && (!processedMemArr[friend2-1])) {
				//first added but second not added
				//add second to same route as first
				memberRouteArr[friend2 -1] = memberRouteArr[friend1 -1];
			} else if((!processedMemArr[friend1-1]) && (processedMemArr[friend2-1])) {
				//second is added but first not added
				//add first to same route as second
				memberRouteArr[friend1 -1] = memberRouteArr[friend2 -1];
			}
			
			//mark them as processed
			processedMemArr[friend1-1] = true;
			processedMemArr[friend2-1] = true;
		}
		
		//add remaining separate routes
		//each one of these routes can have only one drill master
		for(boolean mem: processedMemArr) {
			if(mem == false) {
				maxRoutes++;
				mem = true;
			}
		}
		
		//for each route find the Count of members in the route
		int noOfWays = 1;
		
		for(int routeIndex = 1; routeIndex < currentRouteNo; routeIndex++) {
			
			int teamSize = 0;
			for(int index = 0; index < members; index ++) {
				if(memberRouteArr[index] == routeIndex) {
					teamSize++;
				}
			}
			noOfWays = noOfWays * teamSize;
			noOfWays = noOfWays%(1000000007);
		}
		
		processedMemArr = null;
		relations = null;		
		//System.out.println("max routes = " + maxRoutes + "| noOfWays = " + noOfWays);
		System.out.println(maxRoutes + " " + noOfWays);
		return maxRoutes;
	}
}
