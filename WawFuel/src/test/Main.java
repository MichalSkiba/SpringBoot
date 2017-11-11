package test;




import DAO.Result;

public class Main {

	public static void main(String[] args) {
		
		Result result = new Result();
				result.setFuelType("LPG");
				result.setIdStation(420);
				/*System.out.println(result.getResultList(Result.SELECT_ALL));*/
		System.out.println(result.getRate(Result.SELECT_RATE));
		/*System.out.println(result.getFuelType1());
		System.out.println(result.getAddress());*/
		
		/*result.getIdStation(Result.SELECT_CHEAPEST);
		System.out.println(result.getStationBrand());
		*/
		

	}

}
