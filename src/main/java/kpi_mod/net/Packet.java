
package com.github.kpnmserver.kpi.net;

public class Packet{
	private final String id;
	private final String space;
	private final byte[] data;

	public Packet(final String id, final String space, final byte[] data){
		this.id = id;
		this.space = space;
		this.data = data;
	}

	public String getId(){
		return this.id;
	}

	public String getSpace(){
		return this.space;
	}

	public byte[] getData(){
		return this.data;
	}
}
