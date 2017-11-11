
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.GasStation;

public class Result {

	Connection connection = null;
	private String fuelType;
	private int idStation;

	int id;
	String stationBrand;
	String address;
	String fuelType1;
	String price;
	String date;
	int rate;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationBrand() {
		return stationBrand;
	}

	public void setStationBrand(String stationBrand) {
		this.stationBrand = stationBrand;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFuelType1() {
		return fuelType1;
	}

	public void setFuelType1(String fuelType1) {
		this.fuelType1 = fuelType1;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private List<String> opinions = new ArrayList<>();

	PreparedStatement preparedStatement = null;
	private List<GasStation> resultList = new ArrayList<>();

	public static final String SELECT_LOWEST_PRICE = "SELECT " + "id, " + "stationBrand, " + "address, " + "fuelType, "
			+ "MIN(price) AS min_price, " + "date " + "FROM paliwa.oilstation " + "WHERE fuelType = ? "
			+ "ORDER BY price ASC;\r\n";

	public static final String SELECT_ALL = "SELECT "

			+ "paliwa.oilstation.id, " + "paliwa.oilstation.stationBrand, " + "paliwa.oilstation.address, "
			+ "paliwa.oilstation.fuelType, " + "paliwa.oilstation.price, " + "paliwa.oilstation.date, "
			+ "paliwa.opinions.rate " + "FROM paliwa.oilstation " + "LEFT JOIN paliwa.opinions "
			+ "ON paliwa.oilstation.id=paliwa.opinions.idStation " + "WHERE fuelType = ? " + "ORDER BY price ASC;\r\n";

	/*
	 * public static final String SELECT_ALL = "SELECT "
	 * 
	 * + "id, " + "stationBrand, " + "address, " + "fuelType, " + "price, " +
	 * "date " + "FROM paliwa.oilstation " + "WHERE fuelType = ? " +
	 * "ORDER BY price ASC;\r\n";
	 */

	public static final String SELECT_RATE = "SELECT paliwa.oilstation.id, paliwa.oilstation.stationBrand, paliwa.oilstation.address, paliwa.oilstation.fuelType, paliwa.oilstation.price, paliwa.oilstation.date, paliwa.opinions.rate \r\n"
			+ "FROM paliwa.oilstation left join paliwa.opinions ON paliwa.oilstation.id=paliwa.opinions.idStation\r\n"
			+ "WHERE paliwa.oilstation.fuelType= ? AND paliwa.opinions.idStation = ? ORDER BY price ASC LIMIT 1;";
	public static final String SELECT_ID = "public static final String SELECT_RATE = select * FROM paliwa.opinions where idStation = ?;";
	public static final String SELECT_CHEAPEST = "SELECT paliwa.oilstation.id, paliwa.oilstation.stationBrand, paliwa.oilstation.address, paliwa.oilstation.fuelType, paliwa.oilstation.price, paliwa.oilstation.date, paliwa.opinions.rate FROM paliwa.oilstation inner join paliwa.opinions ON paliwa.oilstation.id=paliwa.opinions.idStation WHERE paliwa.oilstation.fuelType= ? ORDER BY price ASC LIMIT 1;";

	public int getIdStation(String query) {

		try {
			connection = new ConnectManager().getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			stmt.setString(1, fuelType);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				this.id = result.getInt(1);
				this.stationBrand = result.getString(2);
				this.address = result.getString(3);
				this.fuelType1 = result.getString(4);
				this.price = result.getString(5);
				this.date = result.getString(6);
				this.rate = result.getInt(7);

			}

		} catch (SQLException e) {
			System.out.print(e.getErrorCode());
		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.print(e.getErrorCode());
			}
		}
		return idStation;

	}

	public List<GasStation> getResultList(String query) {
		try {
			connection = new ConnectManager().getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			stmt.setString(1, fuelType);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				GasStation gasStation = new GasStation();
				int id = result.getInt(1);
				String stationBrand = result.getString(2);
				String address = result.getString(3);
				String fuelType = result.getString(4);
				String price = result.getString(5);
				String date = result.getString(6);
				int rate = result.getInt(7);

				gasStation.setIdStation(id);
				gasStation.setStationBrand(stationBrand);
				gasStation.setAddress(address);
				gasStation.setFuelType(fuelType);
				gasStation.setPrice(price);
				gasStation.setDate(date);
				gasStation.setRate(rate);

				resultList.add(gasStation);

			}

		} catch (SQLException e) {
			System.out.print(e.getErrorCode());
		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.print(e.getErrorCode());
			}
		}
		return resultList;

	}

	public int getRate(String query) {

		int rate = 0;
		try {
			connection = new ConnectManager().getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);

			stmt.setString(1, fuelType);
			stmt.setInt(2, idStation);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				this.rate = result.getInt(7);

			}

		} catch (SQLException e) {
			System.out.print(e.getErrorCode());
		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.print(e.getErrorCode());
			}
		}
		return rate;

	}

	public int getIdStation() {
		return idStation;
	}

	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}

	public List<String> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<String> opinions) {
		this.opinions = opinions;
	}

	/*
	 * public List<GasStation> getResultList() { select = "SELECT " + "id, " +
	 * "stationBrand, " + "address, " + "fuelType, " + "price, " + "date " +
	 * "FROM paliwa.oilstation " + "WHERE fuelType = ? " +
	 * "ORDER BY price ASC;\r\n";
	 * 
	 * try { connection = new ConnectManager().getConnection(); PreparedStatement
	 * stmt= (PreparedStatement) connection.prepareStatement(select);
	 * stmt.setString(1, fuelType); Statement s = connection.createStatement();
	 * ResultSet result = stmt.executeQuery();
	 * 
	 * while (result.next()) {
	 * 
	 * GasStation gasStation = new GasStation(); int id = result.getInt(1); String
	 * stationBrand = result.getString(2); String address = result.getString(3);
	 * String fuelType = result.getString(4); String price = result.getString(5);
	 * String date = result.getString(6);
	 * 
	 * gasStation.setIdStation(id); gasStation.setStationBrand(stationBrand);
	 * gasStation.setAddress(address); gasStation.setFuelType(fuelType);
	 * gasStation.setPrice(price); gasStation.setDate(date);
	 * 
	 * resultList.add(gasStation); } } catch (SQLException e) {
	 * System.out.print(e.getErrorCode()); } catch (ClassNotFoundException e) {
	 * 
	 * } finally { try { if (connection != null) connection.close(); } catch
	 * (SQLException e) { System.out.print(e.getErrorCode()); } } return resultList;
	 * }
	 */

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	/*
	 * List<GasStation> result = new ArrayList<>();
	 * 
	 * public String getAll() { Connection connection = null; try {
	 * System.out.println("block try"); connection = new
	 * ConnectManager().getConnection(); Statement s = connection.createStatement();
	 * ResultSet station = s.executeQuery(SELECT);
	 * 
	 * 
	 * while (station.next()) { int idStation = station.getInt(1); String
	 * stationBrand = station.getString(2); String address = station.getString(3);
	 * String fuelType = station.getString(4); String price = station.getString(5);
	 * String date = station.getString(6);
	 * 
	 * GasStation gasStation = new GasStation();
	 * 
	 * gasStation.setIdStation(idStation); gasStation.setStationBrand(stationBrand);
	 * gasStation.setAddress(address); gasStation.setFuelType(fuelType);
	 * gasStation.setPrice(price); gasStation.setDate(date);
	 * 
	 * result.add(gasStation);
	 * 
	 * } } catch (SQLException e) { System.out.print(e.getErrorCode()); } catch
	 * (ClassNotFoundException e) {
	 * 
	 * } finally { try { if (connection != null) connection.close(); } catch
	 * (SQLException e) { System.out.print(e.getErrorCode()); }
	 * System.out.println("finally"); } return result.toString(); }
	 */

}
