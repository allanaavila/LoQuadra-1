package br.senac.exemplo_cadastro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoQuadra {

	public static void inserir_quadra(Quadra quadra) throws Exception {
		String sql = "INSERT INTO quadra (id_locador, id_endereco, nome_quadra, tipo_quadra, descricao, url) VALUES(?, ?, ?, ?, ?, ?);";
		
		//try-with-resources
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setInt(1, quadra.getIdLocador());
			ps.setInt(2, quadra.getIdEndereco());
			ps.setString(3, quadra.getNomeQuadra());
			ps.setString(4, quadra.getTipoQuadra());
			ps.setString(5, quadra.getDescricao());
			ps.setString(6, quadra.getUrl());
			
			ps.execute();
		}
	}	
	
	public static List<Quadra> listar_quadra() throws Exception {
		String sql = "SELECT * FROM quadra";
		
		List<Quadra> resultados = new ArrayList<Quadra>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Quadra quadra = new Quadra();
				
				quadra.setId(rs.getInt("id_quadra"));
				quadra.setIdLocador(rs.getInt("Id_locador"));
				quadra.setIdEndereco(rs.getInt("id_endereco"));
				quadra.setNomeQuadra(rs.getString("nome_quadra"));
				quadra.setTipoQuadra(rs.getString("tipo_quadra"));
				quadra.setDescricao(rs.getString("descricao"));
				quadra.setUrl(rs.getString("url"));
				
				resultados.add(quadra);
			}
		}
		return resultados;
	}
	
	public static void atualizar_quadra(Quadra quadra) throws Exception {
		String sql = "UPDATE quadra SET id_endereco = ?, id_locador = ?, nome_quadra=?, tipo_quadra = ?, descricao = ?, url = ? WHERE id_quadra = ?;";
		
		//try-with-resources
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, quadra.getIdEndereco());
			ps.setInt(2, quadra.getIdLocador());
			ps.setString(3, quadra.getNomeQuadra());
			ps.setString(4, quadra.getTipoQuadra());
			ps.setString(5, quadra.getDescricao());
			ps.setString(6, quadra.getUrl());
			ps.setInt(7, quadra.getId());
			
			ps.execute();
		}
		
	}
	
	public static void deletar_quadra(Quadra quadra) throws Exception {
		String sql = "DELETE FROM quadra WHERE id_quadra = ?;";
		
		//try-with-resources
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, quadra.getId());
			
			ps.execute();
		}
		
	}
}
