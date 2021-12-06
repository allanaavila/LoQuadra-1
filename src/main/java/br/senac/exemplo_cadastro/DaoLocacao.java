package br.senac.exemplo_cadastro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaoLocacao {

	
	public static void inserir_locacao(Locacao locacao) throws Exception {
		String sql = "INSERT INTO locacao(id_usuario, id_quadra, id_pagamento, data_hora_inicial, data_hora_final, valor, status_locacao) SELECT id_usuario,(SELECT id_quadra FROM quadra WHERE nome_quadra = ?),(SELECT id_pagamento FROM pagamento WHERE tipo_pagamento = ?), ?,  ?, ?, ? FROM usuario WHERE nome  = ? ;";

		//try-with-resources
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){

			ps.setString(1, locacao.getQuadra_nome());
			ps.setString(2, locacao.getTipo_pagamento());
			ps.setString(3, locacao.getData_hora_inicial());
			ps.setString(4, locacao.getData_hora_final());
			ps.setFloat(5, locacao.getValor());
			ps.setString(6, locacao.getStatus_locacao());
			ps.setString(7, locacao.getNome());
			ps.execute();
		}

	}

	public static List<Locacao> listar_locacao()throws Exception  {

		String sql = "SELECT Q.nome_quadra AS quadra_nome, L.data_hora_inicial, L.data_hora_final, L.valor, L.status_locacao, U.nome, P.tipo_pagamento FROM quadra AS Q LEFT JOIN locacao AS L ON L.id_quadra=Q.id_quadra LEFT JOIN usuario AS U ON L.id_usuario=U.id_usuario LEFT JOIN pagamento P ON P.id_pagamento=L.id_pagamento WHERE L.valor <> '0'";

		List<Locacao> resultados = new ArrayList<Locacao>();

		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Locacao locacao = new Locacao();
				
				locacao.setNome(rs.getString("nome"));
				locacao.setQuadra_nome(rs.getString("quadra_nome"));
				locacao.setTipo_pagamento(rs.getString("tipo_pagamento"));
				locacao.setData_hora_inicial(rs.getString("data_hora_inicial"));
				locacao.setData_hora_final(rs.getString("data_hora_final"));
				locacao.setValor(rs.getFloat("valor"));
				locacao.setStatus_locacao(rs.getString("status_locacao"));

				resultados.add(locacao);
			}
		}
		return resultados;
	}

}
