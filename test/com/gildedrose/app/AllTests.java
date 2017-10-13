package com.gildedrose.app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.gildedrose.app.domain.CheeseItemTest;
import com.gildedrose.app.domain.ConjuredItemTest;
import com.gildedrose.app.domain.ItemTest;
import com.gildedrose.app.domain.LegendaryItemTest;
import com.gildedrose.app.domain.PassItemTest;
import com.gildedrose.app.service.InventoryManagerTest;
import com.gildedrose.app.service.ItemFactoryTest;
import com.gildedrose.app.service.MainTest;

@RunWith(Suite.class)
@SuiteClasses({ CheeseItemTest.class, ConjuredItemTest.class, ItemTest.class,
		LegendaryItemTest.class, PassItemTest.class, InventoryManagerTest.class, ItemFactoryTest.class,MainTest.class})
public class AllTests {

}
