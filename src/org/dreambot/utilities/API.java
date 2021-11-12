package org.dreambot.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.emotes.Emote;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Map;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.methods.world.World;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class API {
	public static String currentBranch = "";
	public static String currentLeaf = "";
	
	private static final Area POTATOES_DRAYNOR = new Area(
			new Tile(3143, 3267, 0),
			new Tile(3140, 3268, 0),
			new Tile(3138, 3270, 0),
			new Tile(3138, 3274, 0),
			new Tile(3139, 3289, 0),
			new Tile(3145, 3291, 0),
			new Tile(3154, 3291, 0),
			new Tile(3158, 3287, 0),
			new Tile(3157, 3277, 0),
			new Tile(3156, 3270, 0),
			new Tile(3153, 3267, 0),
			new Tile(3151, 3268, 0),
			new Tile(3150, 3266, 0),
			new Tile(3143, 3267, 0));
	public static final Area POTATOES_KHARID = new Area(
			new Tile(3241, 3299, 0),
			new Tile(3241, 3303, 0),
			new Tile(3259, 3321, 0),
			new Tile(3266, 3321, 0),
			new Tile(3266, 3298, 0),
			new Tile(3265, 3298, 0),
			new Tile(3262, 3299, 0),
			new Tile(3256, 3300, 0),
			new Tile(3256, 3299, 0));
	public static final Area CABBAGES_DRAYNOR = new Area(
			new Tile(3058, 3283, 0),
			new Tile(3041, 3284, 0),
			new Tile(3041, 3296, 0),
			new Tile(3044, 3299, 0),
			new Tile(3061, 3299, 0),
			new Tile(3063, 3298, 0),
			new Tile(3067, 3298, 0),
			new Tile(3068, 3294, 0),
			new Tile(3068, 3286, 0),
			new Tile(3066, 3283, 0));
	public static final Area CABBAGES_EDGEVILLE = new Area(
			new Tile(3050, 3505, 0),
			new Tile(3053, 3505, 0),
			new Tile(3053, 3503, 0),
			new Tile(3050, 3503, 0));
	public static final Area CABBAGES_ONIONS_RIMMINGTON = new Area(
			new Tile(2953, 3262, 0),
			new Tile(2956, 3259, 0),
			new Tile(2955, 3255, 0),
			new Tile(2956, 3248, 0),
			new Tile(2954, 3246, 0),
			new Tile(2950, 3245, 0),
			new Tile(2947, 3245, 0),
			new Tile(2945, 3249, 0),
			new Tile(2945, 3260, 0),
			new Tile(2947, 3262, 0));
	public static final Area WHEAT_DRAYNOR = new Area(
			new Tile(3107, 3271, 0),
			new Tile(3107, 3276, 0),
			new Tile(3112, 3282, 0),
			new Tile(3112, 3287, 0),
			new Tile(3117, 3291, 0),
			new Tile(3128, 3291, 0),
			new Tile(3131, 3281, 0),
			new Tile(3129, 3272, 0),
			new Tile(3120, 3265, 0),
			new Tile(3110, 3268, 0));
	public static final Area WHEAT_FALADOR = new Area(
			new Tile(2950, 3442, 0),
			new Tile(2950, 3446, 0),
			new Tile(2955, 3446, 0),
			new Tile(2955, 3442, 0));
	public static final Area WHEAT_WESTVARROCK = new Area(
			new Tile(3143, 3458, 0),
			new Tile(3139, 3458, 0),
			new Tile(3139, 3460, 0),
			new Tile(3138, 3461, 0),
			new Tile(3138, 3463, 0),
			new Tile(3143, 3464, 0),
			new Tile(3144, 3464, 0),
			new Tile(3144, 3463, 0),
			new Tile(3143, 3457, 0));
	public static final Area WHEAT_RIMMINGTON = new Area(
			new Tile(2980, 3218, 0),
			new Tile(2976, 3218, 0),
			new Tile(2976, 3214, 0),
			new Tile(2981, 3214, 0));
	public static final Area BOX_SARIM = new Area(
			new Tile(3052, 3234, 0),
			new Tile(3052, 3237, 0),
			new Tile(3044, 3238, 0),
			new Tile(3043, 3245, 0),
			new Tile(3048, 3245, 0),
			new Tile(3047, 3249, 0),
			new Tile(3040, 3249, 0),
			new Tile(3039, 3238, 0),
			new Tile(3033, 3238, 0),
			new Tile(3032, 3233, 0));
	public static final Area BANK_DRAYNOR = new Area(
			new Tile(3104, 3248, 0),
			new Tile(3100, 3244, 0),
			new Tile(3080, 3245, 0),
			new Tile(3080, 3252, 0),
			new Tile(3085, 3253, 0),
			new Tile(3087, 3251, 0),
			new Tile(3095, 3251, 0),
			new Tile(3095, 3255, 0),
			new Tile(3102, 3255, 0));
	public static final Area BANK_FALADOR = new Area(
			new Tile(2952, 3368, 0),
			new Tile(2943, 3368, 0),
			new Tile(2943, 3376, 0),
			new Tile(2949, 3377, 0),
			new Tile(2949, 3381, 0),
			new Tile(2954, 3381, 0),
			new Tile(2954, 3375, 0),
			new Tile(2953, 3374, 0));
	public static final Area BANK_WESTVARROCK = new Area(
			new Tile(3186, 3453, 0),
			new Tile(3193, 3452, 0),
			new Tile(3196, 3435, 0),
			new Tile(3190, 3426, 0),
			new Tile(3176, 3426, 0),
			new Tile(3172, 3439, 0),
			new Tile(3176, 3453, 0));
	public static final Area BANK_EDGEVILLE = new Area(
			new Tile(3101, 3485, 0),
			new Tile(3085, 3485, 0),
			new Tile(3085, 3501, 0),
			new Tile(3088, 3505, 0),
			new Tile(3093, 3506, 0),
			new Tile(3103, 3505, 0),
			new Tile(3105, 3491, 0));
	public static final Area BANK_KHARID = new Area(
			new Tile(3265, 3159, 0),
			new Tile(3280, 3159, 0),
			new Tile(3280, 3183, 0),
			new Tile(3264, 3183, 0),
			new Tile(3261, 3175, 0),
			new Tile(3260, 3168, 0));
	
	public static Tile GE = new Tile(3165,3487,0);
	
	public static String phatType = "";
	public static int phatTries = 4;
	public static Timer randSellTimer;
	public static Timer cameraTimer;
	public static int randPHatPrice = 0;
	public static boolean initBank = false;
	public static boolean setSellAll = false;
	public static int sellAmount = 0;
	public static GameObject nextPick = null;
	public static GameObject lastPicked = null;
	public static int randomRun = 0;
	public static int stuffLeft = 0; // 0
	public static int stuffBanked = 0;
	public static int stuffCount = 0;
	public static int randSellTime = 0;
	public static Tile clickedTile = null;
	public static int banksLeft = 0;
	public static boolean clickedBank = false;
	public static int randomStuffLimit = 0;
	public static int randomWorld = Worlds.getCurrentWorld();
	public static Tile randomTileInBank = null;
	public static Tile randomTileInArea = null;
	public static Area randArea;
	public static int randIdleTime = 0;
	public static String randAreaName = null;
	public static String randBankName = null;
	public static Area closestBank;
	public static int worldHops = 0;
	public static boolean initialized = false;
	public static int walkFails = 0;
	public static int randZoom = 0;
	public static int randPitch = 0;
	public static Random rand2 = new Random();
	public static int coins = 0;
	public static double sleepMod;
	public static Timer runTimer = new Timer(1000000000);
	public static int playersAvoided = 0;
	public static int randDestLimit = 0;
	public static void randomizeTileInArea()
	{
		Tile t = Map.getWalkable(randArea.getRandomTile());
		if(!randArea.contains(t))
		{
			for(int i = 0; i< 99; i++)
			{
				t = Map.getWalkable(randArea.getRandomTile());
				if(randArea.contains(t)) break;
			}
		}
		if(!randArea.contains(t))
		{
			MethodProvider.log("Tried 99 times to grab valid walkable tile in area and failed... sleeping forever...");
			MethodProvider.sleep(1000000000);
		} else	randomTileInArea = t;
		
	}
	public static void randomizeArea()
	{
		int tmp = rand2.nextInt(1000);
		if(tmp < 79) { //79
			randArea = CABBAGES_EDGEVILLE;
			closestBank = BANK_EDGEVILLE;
			randAreaName = "CABBAGES_EDGEVILLE";
			randBankName = "BANK_EDGEVILLE";
			randomizeTileInArea();
		} else if(tmp < 157) {
			randArea = POTATOES_KHARID;
			closestBank = BANK_KHARID;
			randAreaName = "POTATOES_KHARID";
			randBankName = "BANK_KHARID";
			randomizeTileInArea();
		}else if(tmp < 301) {
			randArea = POTATOES_DRAYNOR;
			closestBank = BANK_DRAYNOR;
			randAreaName = "POTATOES_DRAYNOR";
			randBankName = "BANK_DRAYNOR";
			randomizeTileInArea();
		} else if(tmp < 434) {
			randArea = WHEAT_DRAYNOR;
			closestBank = BANK_DRAYNOR;
			randAreaName = "WHEAT_DRAYNOR";
			randBankName = "BANK_DRAYNOR";
			randomizeTileInArea();
		}else if(tmp < 598) {
			randArea = CABBAGES_DRAYNOR;
			closestBank = BOX_SARIM;
			randAreaName = "CABBAGES_DRAYNOR";
			randBankName = "BOX_SARIM";
			randomizeTileInArea();
		}else if(tmp < 645) {
			randArea = CABBAGES_DRAYNOR;
			closestBank = BANK_DRAYNOR;
			randAreaName = "CABBAGES_DRAYNOR";
			randBankName = "BANK_DRAYNOR";
			randomizeTileInArea();
		}else if(tmp < 699) {
			randArea = CABBAGES_ONIONS_RIMMINGTON;
			closestBank = BOX_SARIM;
			randAreaName = "CABBAGES_ONIONS_RIMMINGTON";
			randBankName = "BOX_SARIM";
			randomizeTileInArea();
		}else if(tmp < 845) {
			randArea = WHEAT_FALADOR;
			closestBank = BANK_FALADOR;
			randAreaName = "WHEAT_FALADOR";
			randBankName = "BANK_FALADOR";
			randomizeTileInArea();
		}else if(tmp < 945) {
			randArea = WHEAT_WESTVARROCK;
			closestBank = BANK_WESTVARROCK;
			randAreaName = "WHEAT_WESTVARROCK";
			randBankName = "BANK_WESTVARROCK";
			randomizeTileInArea();
		}else if(tmp <= 1000) {
			randArea = WHEAT_RIMMINGTON;
			closestBank = BOX_SARIM;
			randAreaName = "WHEAT_RIMMINGTON";
			randBankName = "BOX_SARIM";
			randomizeTileInArea();
		}
		tmp = rand2.nextInt((int) (500 * sleepMod));
		if(tmp < 25) banksLeft = 3;
		else if(tmp < 55) banksLeft = 4;
		else if(tmp < 120) banksLeft = 5;
		else if(tmp < 200) banksLeft = 6;
		else if(tmp < 290) banksLeft = 7;
		else if(tmp < 390) banksLeft = 8;
		else if(tmp < 420) banksLeft = 9;
		else if(tmp < 570) banksLeft = 10;
		else if(tmp < 700) banksLeft = 11;
		else if(tmp < 800) banksLeft = 12;
		else if(tmp < 900) banksLeft = 13;
		else if(tmp < 1000) banksLeft = 14;
		else if(tmp < 1150) banksLeft = 15;
		else if(tmp < 1300) banksLeft = 16;
		else if(tmp < 1450) banksLeft = 17;
		else if(tmp < 1600) banksLeft = 18;
		else if(tmp < 1800) banksLeft = 19;
		else if(tmp < 2000) banksLeft = 20;
	}
	public static void randomAFK()
	{
		int tmp = API.rand2.nextInt(20000);
		if(tmp < 2)  
		{
			int tmp2 = (int) ((double) 50 + API.rand2.nextInt(60000) * API.sleepMod);
			MethodProvider.logInfo("AFK: 0.001% chance, max 240s, randomized for " +tmp2+ "ms");
			MethodProvider.sleep(tmp2);
		}
		else if(tmp < 6)  
		{
			int tmp2 = (int) ((double) 50 + API.rand2.nextInt(30000) * API.sleepMod);
			MethodProvider.logInfo("AFK: 0.003% chance, max 120s, randomized for " +tmp2+ "ms");
			MethodProvider.sleep(tmp2);
		}
		else if(tmp < 25)
		{
			int tmp2 = (int) ((double) 50 + API.rand2.nextInt(10000) * API.sleepMod);
			MethodProvider.logInfo("AFK: 0.095% chance, max 40s, randomized for " +tmp2+ "ms");
			MethodProvider.sleep(tmp2);
		}
		else if(tmp < 150)  
		{
			int tmp2 = (int) ((double) 50 + API.rand2.nextInt(5000) * API.sleepMod);
			MethodProvider.logInfo("AFK: .625% chance, max 20s, randomized for " +tmp2+ "ms");
			MethodProvider.sleep(tmp2);
		}
		else if(tmp < 1000)  
		{
			int tmp2 = (int) ((double) 600 + API.rand2.nextInt(1200) * API.sleepMod);
			MethodProvider.logInfo("AFK: 4.25% chance, max 6.0s, randomized for " +tmp2+ "ms");
			MethodProvider.sleep(tmp2);
		}
		else if(tmp < 3000)  
		{
			int tmp2 = (int) ((double) 600 + API.rand2.nextInt(600) * API.sleepMod);
			MethodProvider.logInfo("AFK: 10.0% chance, max 3.2s, randomized for " +tmp2+ "ms");
			MethodProvider.sleep(tmp2);
		}
	}
	public static void randomizeWorld()
	{
		List<World> worlds = Worlds.noMinimumLevel();
		List<World> verifiedWorlds = new ArrayList<World>();
		for(World tmp : worlds)
		{
			if(		tmp.isMembers()
					|| tmp.isPVP()
					|| !tmp.isNormal()
					|| tmp.isSuspicious()
					|| tmp.isTournamentWorld()
					|| tmp.isTwistedLeague()
					|| tmp.isDeadmanMode()
					|| tmp.getWorld() == 301
					|| tmp.getWorld() == 308
					|| tmp.getWorld() == 335)
			{
				//skip world
			} else verifiedWorlds.add(tmp);
		}
		randomWorld = verifiedWorlds.get(rand2.nextInt(verifiedWorlds.size() - 1)).getWorld();
		
	}
}
