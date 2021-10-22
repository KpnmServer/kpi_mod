
package com.github.kpnmserver.kpi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import com.github.kpnmserver.kpi.KpiMod;

public final class KpiModInitializer implements ModInitializer{
	public KpiModInitializer(){}

	@Override
	public void onInitialize(){
		KpiMod.LOGGER.info("Kpi is onInitialize");
		ServerLifecycleEvents.SERVER_STARTING.register(KpiMod.INSTANCE::onStarting);
		ServerLifecycleEvents.SERVER_STARTED.register(KpiMod.INSTANCE::onStarted);
		CommandRegistrationCallback.EVENT.register(KpiMod.INSTANCE::onRegisterCommands);
		ServerLifecycleEvents.SERVER_STOPPING.register(KpiMod.INSTANCE::onStopping);
		ServerLifecycleEvents.SERVER_STOPPED.register(KpiMod.INSTANCE::onStopped);
	}
}