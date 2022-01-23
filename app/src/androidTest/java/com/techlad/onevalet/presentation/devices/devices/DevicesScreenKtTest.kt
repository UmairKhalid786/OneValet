package com.techlad.onevalet.presentation.devices.devices

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techlad.onevalet.MainActivity
import com.techlad.onevalet.di.TestDataSourceModule
import com.techlad.onevalet.di.TestRepositoriesModule
import com.techlad.onevalet.di.TestUseCasesModule
import com.techlad.onevalet.presentation.navigation.Screens
import com.techlad.onevalet.ui.theme.OneValetTheme
import com.techlad.onevalet.utils.TestTags.DEVICES_LIST
import com.techlad.onevalet.utils.TestTags.EDIT_TEXT_CROSS_BTN
import com.techlad.onevalet.utils.TestTags.SEARCH_BAR
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(TestDataSourceModule::class, TestUseCasesModule::class, TestRepositoriesModule::class)
class DevicesScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @ExperimentalMaterialApi
    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            val navController = rememberNavController()
            OneValetTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screens.Devices.title
                ) {
                    composable(route = Screens.Devices.title) {
                        DevicesScreen(navController = navController)
                    }
                }
            }
        }
    }

    @ExperimentalMaterialApi
    @Test
    fun enter_search_text_visibility() {
        composeRule.onNodeWithTag(SEARCH_BAR).assertIsDisplayed()
    }

    @ExperimentalMaterialApi
    @Test
    fun check_list_visibility() {
        composeRule.onNodeWithTag(DEVICES_LIST).assertIsDisplayed()
    }

    @ExperimentalMaterialApi
    @Test
    fun check_if_text_clear_on_cross_button_press() {
        composeRule.onNodeWithTag(SEARCH_BAR).performTextInput("iphone")
        composeRule.onNodeWithTag(EDIT_TEXT_CROSS_BTN).performClick()
        composeRule.onNodeWithTag(SEARCH_BAR).assert(hasText(""))
    }

    @ExperimentalMaterialApi
    @Test
    fun enter_search_text_and_check_if_results_are_same() {
        composeRule.onNodeWithTag(SEARCH_BAR).assertExists()
        composeRule.onNodeWithTag(SEARCH_BAR).performTextInput("iphone")
        composeRule.onNodeWithTag(DEVICES_LIST).onChildren().assertAny(hasTestTag("iPhone"))
    }
}