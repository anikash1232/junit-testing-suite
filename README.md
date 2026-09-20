# JUnit Test Suite

Test suites written against a deliberately under-specified adventure-game library — finding
the bugs by writing the tests that expose them.

## What it does

The exercise inverts normal assignment work: the implementation is given, and the job is to
write tests thorough enough to characterise what it actually does versus what it claims to.
Roughly 270 lines of tests across five suites, covering an inventory system, player state,
2D positioning, item behaviour, and a string alphabetizer.

- **Inventory** — adding, removing, capacity limits, duplicate handling
- **Player** — state transitions, movement, inventory interaction
- **Position** — 2D coordinates and directional movement
- **Item** — item identity and equality semantics
- **Alphabetizer** — string ordering, including the edge cases plain sorting misses

## Architecture

```
adventure/
  Player, PlayerImpl          player state
  Inventory, InventoryImpl    item storage with capacity rules
  Position, PositionImpl      2D coordinates
  Item, ItemImpl              inventory items
  Direction                   movement enum
alphabetizer/
  Alphabetizer                string ordering

SorcererPlayerTests           \
SorcererInventoryTests         |
EnchanterPositionTests         |  five suites, escalating in thoroughness
EnchanterItemTests             |
ApprenticeAlphabetizerTests   /
```

The tests target boundaries rather than happy paths — empty and full inventories, movement
at coordinate limits, equality between distinct instances holding equal values, and
alphabetization across case and punctuation.

## Running it

Requires Java 17+ and Maven.

```bash
mvn clean test
```
