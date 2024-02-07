import java.util.*;


public class Station {
private String stationName;
private int ID;
Gasoline [] gasolineArray;
Diesel[] dieselArray;
int gasolineCounter=0;
int dieselCounter=0;
Service[] serviceArray;
double totalPaidForGasoline=0,
totalPaidForDiesel=0;
double averageGasolinePrice=0,
totalGasolineInStation=0,
averageDieselPrice=0,
totalDieselInStation=0;

	
	public Station() {
		
		gasolineArray=new Gasoline[10];
		dieselArray=new Diesel[10];
		serviceArray=new Service[10];
	}
	public static Station createStation() {
		Scanner scanner=new Scanner(System.in);
		Station station=new Station();
		System.out.printf("Please enter the name of the Station: ");
		station.stationName=scanner.nextLine();
		System.out.printf("Please enter the Station ID: ");
		station.ID=scanner.nextInt();
		return station;
	}
	public static void findStationAndAddGasoline(Station[] stationArray) {
		
		Scanner scanner=new Scanner(System.in);
		int idFinder;
		int counter=0;
		
		System.out.printf("Please enter the ID of the Station you want to search: ");
		idFinder=scanner.nextInt();
		System.out.println("");
		while(stationArray[counter]!=null) {
			Station station=stationArray[counter];
			if(idFinder==station.ID) {
				Gasoline gasoline=new Gasoline();
				scanner.nextLine();
				System.out.printf("Please enter the origin of the Gasoline: ");
				gasoline.origin=scanner.nextLine();
				System.out.printf("Please enter the price per liter: ");
				gasoline.pricePerLiter=scanner.nextDouble();
				System.out.printf("Please enter the total shipment volume in liter: ");
				gasoline.totalLiters=scanner.nextDouble();
				station.gasolineArray[station.gasolineCounter]=gasoline;
				station.gasolineCounter++;
				station.totalGasolineInStation+=gasoline.totalLiters;
				station.totalPaidForGasoline+=gasoline.totalLiters * gasoline.pricePerLiter;
				station.averageGasolinePrice=station.totalPaidForGasoline / station.totalGasolineInStation;
				System.out.println("");
				System.out.println("The total gasoline liters in Station # "+station.ID+" is "+station.totalGasolineInStation);
				System.out.println("The average gasoline price in Station #"+station.ID+" is "+station.averageGasolinePrice);
				
				break;
			}
			counter++;
		}
		if(stationArray[counter]==null) {
			System.out.println("No station found with the given ID!");
		}
	}
	public static void findStationAndAddDiesel(Station[] stationArray) {
		
		Scanner scanner=new Scanner(System.in);
		int idFinder;
		int counter=0;
		
		System.out.printf("Please enter the ID of the Station you want to search: ");
		idFinder=scanner.nextInt();
		System.out.println("");
		while(stationArray[counter]!=null) {
			Station station=stationArray[counter];
			if (idFinder==station.ID) {
				Diesel diesel=new Diesel();
				scanner.nextLine();
				System.out.printf("Please enter the origin of the Diesel: ");
				diesel.origin=scanner.nextLine();
				System.out.printf("Please enter the price per liter: ");
				diesel.pricePerLiter=scanner.nextDouble();
				System.out.printf("Please enter the total shipment volume in liter: ");
				diesel.totalLiters=scanner.nextDouble();
				station.dieselArray[station.dieselCounter]=diesel;
				station.dieselCounter++;
				station.totalDieselInStation+=diesel.totalLiters;
				station.totalPaidForDiesel+=diesel.totalLiters*diesel.pricePerLiter;
				station.averageDieselPrice=station.totalPaidForDiesel/station.totalDieselInStation;
				System.out.println("");
				System.out.println("The total diesel liters in Station # "+station.ID+" is "+station.totalDieselInStation);
				System.out.println("The average diesel price in Station # "+station.ID+" is "+station.averageDieselPrice);
				break;
			}
			counter++;
		}
		if(stationArray[counter]==null) {
			System.out.println("No station found with the given ID!");
			System.out.println("");
		}
	}
	
	public static void displayStationInventory(Station[] stationArray) {
		
		Scanner scanner=new Scanner(System.in);
		int idFinder;
		int counter=0;
		System.out.printf("Please enter the ID of the Station you want to display: ");
		idFinder=scanner.nextInt();
		while(stationArray[counter]!=null) {
			Station station=stationArray[counter];
			if(idFinder==station.ID) {
				System.out.println("Displaying the inventory of Station #"+station.ID);
				System.out.println("");
				for(int i=0;i<station.gasolineCounter;i++) {
					System.out.println("Gasoline...");
					System.out.println("The origin is: "+station.gasolineArray[i].origin);
					System.out.println("Price per liter is: "+station.gasolineArray[i].pricePerLiter);
					System.out.println("Total liters of this gasoline is: "+station.gasolineArray[i].totalLiters);
					System.out.println("");
				}
				System.out.println("The total gasoline liters in Station #"+station.ID+" is "+station.totalGasolineInStation);
				System.out.println("The average gasoline price in Station #"+station.ID+" is "+station.averageGasolinePrice);
				System.out.println("");
				for(int i=0;i<station.dieselCounter;i++) {
					System.out.println("Diesel...");
					System.out.println("The origin is: "+station.dieselArray[i].origin);
					System.out.println("Price per liter is: "+station.dieselArray[i].pricePerLiter);
					System.out.println("Total liters of this diesel is: "+station.dieselArray[i].totalLiters);
					System.out.println("");
				}
				System.out.println("The total diesel liters in Station #"+station.ID+" is "+station.totalDieselInStation);
				System.out.println("The average diesel price in Station #"+station.ID+" is "+station.averageDieselPrice);
				System.out.println("");
				break;
				}
			counter++;
			}
		if(stationArray[counter]==null) {
			System.out.println("No station found with the given ID!");
			System.out.println("");
		}
	}
		public static void sellGasoline(Station[] stationArray)
		{	Scanner scanner=new Scanner(System.in);
			int idFinder;
			int counter=0;
			System.out.printf("Please enter the ID of the Station you want to sell Gasoline: ");
			System.out.println("");
			idFinder=scanner.nextInt();
			while(stationArray[counter]!=null) {
				Station station=stationArray[counter];
				if(idFinder==station.ID) {
					GasolineService gasolineService=new GasolineService();
					scanner.nextLine();
					System.out.printf("Please enter the car plate: ");
					gasolineService.carPlate=scanner.nextLine();
					System.out.printf("Please enter the gasoline liter: ");
					gasolineService.litersBought=scanner.nextDouble();
					
					
					if(gasolineService.litersBought<=station.totalGasolineInStation) {
						
					
					
					}	else {
						System.out.println("Not enough gasoline in the station!");
						break;
					}
					
					String answer;
					System.out.printf("Please enter if you have a coupon (y/n): ");
					scanner.nextLine();
					answer=scanner.nextLine();
					
					gasolineService.hasCoupon=(answer.equalsIgnoreCase("y") ? true: false);
					
					if (gasolineService.hasCoupon) {
						int j=0;
						
						station.totalGasolineInStation-=gasolineService.litersBought;
						
						
						gasolineService=new GasolineService(gasolineService.carPlate,gasolineService.litersBought,gasolineService.hasCoupon);
						gasolineService.revenue=gasolineService.makeTransaction(station.averageGasolinePrice*0.9);
						station.totalPaidForGasoline-=gasolineService.revenue;
						
						for(int i=0;station.serviceArray[i]!=null;i++) {
							
							j++;
						}
						station.serviceArray[j]=gasolineService;
						
					}
					else {
						int j=0;
						
						station.totalGasolineInStation-=gasolineService.litersBought;
						
						
						gasolineService=new GasolineService(gasolineService.carPlate,gasolineService.litersBought,gasolineService.hasCoupon);
						gasolineService.revenue=gasolineService.makeTransaction(station.averageGasolinePrice);
						station.totalPaidForGasoline-=gasolineService.revenue;
						for(int i=0;station.serviceArray[i]!=null;i++) {
							
							j++;
						}
						station.serviceArray[j]=gasolineService;
						
					}
				}counter++;
				}
				}
				
		
		
			
		
				
			
			
		
		public static void sellDiesel(Station[] stationArray) {
			Scanner scanner=new Scanner(System.in);
			int idFinder;
			int counter=0;
			System.out.printf("Please enter the ID of the Station you want to sell Diesel: ");
			System.out.println("");
			idFinder=scanner.nextInt();
			while(stationArray[counter]!=null) {
				Station station=stationArray[counter];
				if(idFinder==station.ID) {
					DieselService dieselService=new DieselService();
					scanner.nextLine();
					System.out.printf("Please enter the car plate: ");
					dieselService.carPlate=scanner.nextLine();
					System.out.printf("Please enter the diesel liter: ");
					dieselService.litersBought=scanner.nextDouble();
					dieselService=new DieselService(dieselService.carPlate,dieselService.litersBought);
					
					if(dieselService.litersBought<=station.totalDieselInStation) {
						
					
					
					}	else {
						System.out.println("Not enough diesel in the station!");
						break;
					}
					
					String answer;
					System.out.printf("Please enter if you want discounted anti-freeze (y/n): ");
					scanner.nextLine();
					answer=scanner.nextLine();
					
					dieselService.discountedAntiFreeze=(answer.equalsIgnoreCase("y") ? true: false);
					
					if (dieselService.discountedAntiFreeze) {
						int j=0;
						System.out.println("Please enter how many anti-freeze you want: ");
						dieselService.discountedAntiFreezeCount=scanner.nextInt();
						station.totalDieselInStation-=dieselService.litersBought;
						
						station.totalPaidForDiesel=station.totalPaidForDiesel-(dieselService.revenue-(dieselService.discountedAntiFreezeCount*dieselService.discountedAntiFreezePrice));
						dieselService=new DieselService(dieselService.carPlate,dieselService.litersBought,dieselService.discountedAntiFreeze,dieselService.discountedAntiFreezeCount);
						dieselService.revenue=dieselService.makeTransaction(station.averageDieselPrice*0.9);
						for(int i=0;station.serviceArray[i]!=null;i++) {
							
							j++;
						}
						station.serviceArray[j]=dieselService;
						
					}
					else {
						int j=0;
						
						station.totalDieselInStation-=dieselService.litersBought;
						
						
						dieselService=new DieselService(dieselService.carPlate,dieselService.litersBought);
						dieselService.revenue=dieselService.makeTransaction(station.averageGasolinePrice);
						station.totalPaidForDiesel-=dieselService.revenue;
						for(int i=0;station.serviceArray[i]!=null;i++) {
							
							j++;
						}
						station.serviceArray[j]=dieselService;
						
					}
				}counter++;
				}
			
		}
		public static void displayServices(Station[] stationArray) {
			Scanner scanner=new Scanner(System.in);
			FuelService fuelService=new FuelService();
			int idFinder;
			int counter=0;
			System.out.printf("Please enter the ID of the Station you want to display: ");
			idFinder=scanner.nextInt();
			while(stationArray[counter]!=null) {
				Station station=stationArray[counter];
				if(idFinder==station.ID) {
					System.out.println("Displaying the sold services of Station #"+station.ID);
					System.out.println("");
					for(int i=0;station.serviceArray[i]!=null;i++)
					{
						Service service=station.serviceArray[i];
						
						if(service instanceof GasolineService) {
							
							System.out.println("Gasoline Service...");
							System.out.println("Bought "+((GasolineService) service).litersBought+" liters");
							System.out.println("Car Plate is "+((GasolineService) service).carPlate);
							System.out.println("The revenue from this service is "+((GasolineService) service).revenue);
							System.out.println("");
							if(((GasolineService) service).hasCoupon) {
								System.out.println("Has 10% discount coupon");
								System.out.println("");
							}
						}
						else if(service instanceof DieselService) {
							System.out.println("Diesel Service...");
							System.out.println("Bought "+((DieselService) service).litersBought+" liters");
							System.out.println("Car plate is "+((DieselService) service).carPlate);
							System.out.println("The revenue from this service is "+((DieselService) service).revenue);
							System.out.println("");
							if(((DieselService) service).discountedAntiFreeze) {
								System.out.println("Bought "+((DieselService) service).discountedAntiFreezeCount+ "discounted anti-freeze.");
								System.out.println("");
							}
						}
					}
					break;
					}
				counter++;
				}
			if(stationArray[counter]==null) {
				System.out.println("No station found with the given ID!");
				System.out.println("");
			}
		}
		
	
}
