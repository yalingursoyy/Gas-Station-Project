

public enum MenuItem {
	
		M1("1.Create a new station"),
		M2("2.Add gasoline to a station inventory"),
		M3("3.Add diesel to a station inventory"),
		M4("4.Display a station inventory"),
		M5("5.Sell gasoline to customer"),
		M6("6.Sell diesel to customer"),
		M7("7.Display sold services so far"),
		M8("8.Exit");
		
		private final String item;
		
		MenuItem(String mItem){
			item=mItem;
		}
		String getMenuItem() {
			return item;
		}
		public static void printMenu(){
			for (MenuItem menuItem: MenuItem.values()) {
				System.out.printf("%s\n",menuItem.getMenuItem());
			}
		}
		
		
	
}
