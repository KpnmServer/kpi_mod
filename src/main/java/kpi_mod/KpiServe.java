
package com.github.kpnmserver.kpi;

import java.util.Map;
import java.util.HashMap;

import com.github.kpnmserver.kpi.net.Packet;
import com.github.kpnmserver.kpi.net.PacketHandler;

public abstract class KpiServe implements PacketHandler{
	private static final Map<String, KpiServe> SERVE_MAP = new HashMap<>();

	public static final KpiServe getServe(final String id){
		return SERVE_MAP.get(id);
	}

	private final String id;
	private boolean enabled = false;

	protected KpiServe(final String id){
		if(id == null){
			throw new IllegalArgumentException("id == null");
		}
		synchronized(SERVE_MAP){
			if(SERVE_MAP.containsKey(id)){
				throw new IllegalStateException("id '" + id + "' is already exists");
			}
			SERVE_MAP.put(id, this);
		}
		this.id = id;
	}

	public final String getId(){
		return this.id;
	}

	public final boolean isEnabled(){
		return this.enabled;
	}

	public final void setEnabled(final boolean enabled){
		this.enabled = enabled;
	}

	public final void sendPacket(final Packet pkt){
		//
	}

	public final Packet newPacket(final String space, final byte[] data){
		return new Packet(this.id, space, data);
	}

	public final void sendData(final String space, final byte[] data){
		this.sendPacket(this.newPacket(space, data));
	}

	public final void sendData(final byte[] data){
		this.sendPacket(this.newPacket("", data));
	}

	public abstract void onRegister();

	public abstract void onUnregister();

	@Override
	public abstract void onMessage(Packet pkt);
}
