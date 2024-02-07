public class GasolineService extends FuelService
{
public boolean hasCoupon;

public GasolineService(String carPlate,double litersBought,boolean hasCoupon) {
	this.carPlate=carPlate;
	this.litersBought=litersBought;
	this.hasCoupon=hasCoupon;
}

public GasolineService() {
	
}

void displayServiceInfo()
{
	
}
double makeTransaction(double price)
{	
	
	return super.makeTransaction(price*litersBought);
	
}
}