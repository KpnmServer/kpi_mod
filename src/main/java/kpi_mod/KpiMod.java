
package com.github.kpnmserver.kpi;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;

import com.github.kpnmserver.kpi.KpiServe;

public final class KpiMod{
	public static final KpiMod INSTANCE = new KpiMod();
	public static final Logger LOGGER = LogManager.getLogger("KPI");

	private MinecraftServer server = null;
	private File folder;

	private KpiMod(){
		this.folder = new File("kpidata");
		if(!this.folder.exists()){
			this.folder.mkdirs();
		}
	}

	public File getDataFolder(){
		return this.folder;
	}

	public File getDataFolder(final String id){
		final File folder = new File(this.folder, id);
		if(!folder.exists()){
			folder.mkdirs();
		}
		return folder;
	}

	public MinecraftServer getServer(){
		return this.server;
	}

	public void onStarting(MinecraftServer server){
		this.server = server;
	}

	public void onStarted(MinecraftServer server){
	}

	public void onRegisterCommands(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated){
	}

	public void onReload(){
	}

	public void onSave(){
	}

	public void onStopping(MinecraftServer server){
	}

	public void onStopped(MinecraftServer server){
		this.server = null;
	}

	public void registerServe(final KpiServe serve){
		LOGGER.info("Registering serve" + serve.toString());
	}

}
