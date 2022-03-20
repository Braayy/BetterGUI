# BetterGUI
A simple but powerful GUI lib for Bukkit
----------------------------------------

## Usage
BetterGUI uses a POO approach for simplicity, so using it is just like creating a class.

First, `GUIListener.register(JavaPlugin)` should be called on the plugin's `onEnable()` method.
This is where all events are handled, so if it is not registered, nothing about clicking and closing will work.
Calling this method twice will cause a warning to be logged in the console.

### Basics
For a common GUI, create a class extending `GUI`.

For a paginated GUI, create a class extending `PaginatedGUI`.

In both cases you should overwrite the `setup()` method, where you will configure your GUI.

Every time the GUI is opened or updated the `setup()` method is called.

### GUI Configuration
Inside the `setup()` method you can:
- `setTitle(String)` sets the title of the GUI.
- `setSize(GUISize)` sets the size of the GUI.
- `setSlotsPerPage(GUISlotsPerPage)` sets the slots per page of the GUI when in a paginated GUI.
- `setSlots(List<GUISlot>)` sets **all** the slots of the GUI when in a paginated GUI.

There are six options for a GUI size that you can choose from:
- `GUISize.ONE_LINE`
- `GUISize.TWO_LINES`
- `GUISize.THREE_LINES`
- `GUISize.FOUR_LINES`
- `GUISize.FIVE_LINES`
- `GUISize.SIX_LINES`

There are four options for a GUI slots per page that you can choose from:
- `GUISlotsPerPage.ONE_LINE`
- `GUISlotsPerPage.TWO_LINES`
- `GUISlotsPerPage.THREE_LINES`
- `GUISlotsPerPage.FOUR_LINES`

### GUI Slot types
After configuring the GUI you can add GUI slots. There are 4 types of GUI slots:
- `GUISlotButton` a clickable slot.
- `GUISlotDisplay` a visual slot.
- `GUISlotPlaceable` a slot where you can place an item.
- `GUISlotCapturable` a slot where you can grab an item.

### GUI Slot types methods
Each GUI slot type has a corresponding method:
- `addSlot(int, GUISlot)` adds a generic GUISlot in the specified slot index, this is for your owns GUI slots. 
- `addButton(int, ItemStack, GUISlotClickHandler)` adds a GUISlotButton with a click handler in the specified slot index.
- `addButton(int, ItemStack, GUISlotCleanClickHandler)` adds a GUISlotButton with a non-argument click handler in the specified slot index.
- `addCapturable(int, ItemStack, GUISlotClickHandler)` adds a GUISlotCapturable with a click handler in the specified slot index.
- `addCapturable(int, ItemStack)` adds a GUISlotCapturable without a click handler in the specified slot index.
- `addDisplay(int, ItemStack)` adds a GUISlotDisplay with the specified icon and slot index.
- `addPlaceable(int, GUISlotPlaceableClickHandler)` adds a GUISlotPlaceable with a click handler in the specified slot index.
- `addPlaceable(int)` adds a GUISlotPlaceable without a click handler in the specified slot index.

### Actions
There are five actions to do when a button in clicked:
- `simpleUpdate()` updates the GUI by only changing the items.
- `fullUpdate()` updates the GUI by changing everything, including title, slots and size.
- `open(Player)` opens the GUI to the player.
- `open(Player, GUI)` opens the GUI to the player as a child of the current GUI.
- `back()` opens the parent GUI of the current GUI.

### PaginatedGUI
To create a GUI that has pages, in the `setup()` method you just pass the **complete** list of slots to the `setSlots(List<GUISlot>)`, and set the slots per page with `setSlotsPerPage(GUISlotsPerPage)`.

With this two configurations, the `PaginatedGUI` can chop the list in pages that can be navigated through `nextPage(boolean)` and `previousPage(boolean)`, the boolean indicates if the GUI should update the title too(for GUIs that has the page number in the title).

The page slots starts from slot 9(second line), and go until reach the end of the entire slot list or the slots per page configuration, so have this in mind when choosing the GUI size and GUI slots per page configuration.

### StateGUI
To create a GUI that has a state machine built-in to it, create a class/interface that represents a state of your GUI and implement/extend the `GUIState` interface.

In a StateGUI you can at any point call `setState(GUIState, boolean)`
The state passed will be the new state in the next `setup()` call and the boolean tells StateGUI if it should update only the items or everything.

Every time the `setup()` of the GUI is called, the `setup()` of the current state is called, so things related to only one state should be placed there and things related to all states, like the style of the GUI, should be placed in the GUI's `setup()`.

`StateGUI` and `GUIState` asks for 2 type parameters, the first one is the type of your GUI and the second the type of the State of your GUI.

Example:
```java
public final class TestingGUI extends StateGUI<TestingGUI, TestingState> {
    public TestingGUI() {
        // Here you pass the initial state, the state of your GUI when it is open the first time
        super(TestingState.INIT);
    }
    
    // Rest of your gui here
}

public interface TestingState extends GUIState<TestingGUI, TestingState> {
    /*
    I like to create this field, so I do not have to create a new object representing
    this state that has no internal properties every time I need to come back to it
    */
    TestingState INIT = new InitState();
    
    final class InitState implements TestingState {
        @Override
        public void setup(TestingGUI gui) {
            // Place here the slots and logic when the GUI is in the InitState here
        }
    }
    
    // Rest of your states here
}
```

### Async
You can pass a ExecutorService as argument on a `GUI` or `PaginatedGUI` constructor to allow async `setup()` calls.

When the async mode in on in a GUI, every `setup()` call will be made as a task in the ExecutorService.

If you just want the first call to the `setup()` method to be async and then the rest can be sync, you can use the `becomeSync()` method.

Don't forget to shut down your ExecutorService in the disabling of the plugin.

## Installation
### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

```xml
<dependency>
    <groupId>com.github.Braayy</groupId>
    <artifactId>BetterGUI</artifactId>
    <version>1.2.0-SNAPSHOT</version>
</dependency>
```

### Gradle
```groovy
maven { url 'https://jitpack.io' }
```

```groovy
implementation 'com.github.Braayy:BetterGUI:1.2.0-SNAPSHOT'
```