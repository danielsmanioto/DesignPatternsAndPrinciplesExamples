package com.danielsmanioto.pedido;

import java.util.Calendar;

/**
 * Representa um Pedido Builder
 * 
 * Respons�vel por setar os campos de um pedido e retorna-lo
 *   - Todos os campos de set retornam um PedidoBuilder
 *   - Um m�todo retorna o Pedido
 *   - Os atributos s�o basicamente uma c�pia dos atriutos do pedido
 * 
 * @see Pedido
 * @author daniel
 *
 */
public class PedidoBuilder {
	
	private Integer id;
	private Calendar data;
	
	/**
	 * Seta o campo id
	 * @param id
	 * @return
	 */
	public PedidoBuilder comId(Integer id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Seta o campo Data
	 * @param data
	 * @return
	 */
	public PedidoBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}

	/**
	 * Retorna um Pedido
	 * @return
	 */
	public Pedido controi() {
		return new Pedido(this.id, this.data);
	}

}
