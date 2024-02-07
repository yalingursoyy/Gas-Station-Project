public class DieselService extends FuelService {
boolean discountedAntiFreeze;
int discountedAntiFreezeCount=0;
double discountedAntiFreezePrice;

public DieselService(String carPlate,double litersBought, boolean discountedAntiFreeze,int discountedAntiFreezeCount) {
	this.carPlate=carPlate;
	this.litersBought=litersBought;
	this.discountedAntiFreeze=discountedAntiFreeze;
	this.discountedAntiFreezeCount=discountedAntiFreezeCount;
	this.discountedAntiFreezePrice=25;
	
}
public DieselService(String carPlate,double litersBought) {
	this.carPlate=carPlate;
	this.litersBought=litersBought;
}
public DieselService() {
	
}


void displayServiceInfo()
{
	
}
double makeTransaction(double price)
{
	this.revenue=super.makeTransaction(price*litersBought+discountedAntiFreezeCount*discountedAntiFreezePrice);
	return super.makeTransaction(price*litersBought+discountedAntiFreezeCount*discountedAntiFreezePrice);
}
}