package br.com.fiap.tads.ddd.cafe.cafe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tads.ddd.cafe.cafe.model.Coffee;

public class CoffeeRepository extends Repository{
	
	public static List<Coffee> findAll(){
		
		List<Coffee> retorno = new ArrayList<>();
		
		String sql = "SELECT * FROM DDD_COFFEE";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					Long id = rs.getLong("ID");
					String name = rs.getString("NAME");
					Double price = rs.getDouble("PRICE");
					
					retorno.add(new Coffee(id, name, price));
				}
			}else {
				System.out.println("Não encontramos registros no banco de dados");
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível consultar os registros no BD"+ e.getMessage()); 
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException e){
				System.out.println("Erro ao tentar fechar o Statement ou ResultSet");
			}
			if(connection != null) {
				closeConnection();
			}
		}
		return retorno;
	}
	
}
