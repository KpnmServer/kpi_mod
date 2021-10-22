
package com.github.kpnmserver.kpi.net;

import com.github.kpnmserver.kpi.net.Packet;

public interface PacketHandler{
	public void onMessage(Packet pkt);
}
