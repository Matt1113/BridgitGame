import java.util.ArrayList;
import java.util.Arrays;

import tester.*;
import javalib.impworld.*;
import java.awt.Color;
import javalib.worldimages.*;

//Example BridgIt class
class ExampleBridgIt {

  ArrayList<ArrayList<ICell>> cl20;
  WorldScene ws20;
  BridgIt bg20;

  ICell out20;
  Cell cell100;
  Cell cell101;

  Cell c1;
  Cell c2;
  Cell c3;
  Cell c4;
  Cell c5;
  Cell c6;
  Cell c7;
  Cell c8;
  Cell c9;
  Cell c10;
  Cell c11;
  Cell c12;
  Cell c13;
  Cell c14;
  Cell c15;
  Cell c16;
  Cell c17;
  Cell c18;
  Cell c19;
  Cell c20;
  Cell c21;
  Cell c22;
  Cell c23;
  Cell c24;
  Cell c25;
  Cell c26;
  Cell c27;
  Cell c28;
  Cell c29;
  Cell c30;
  ArrayList<ArrayList<ICell>> madeList;
  WorldScene emptyScene;
  WorldScene mutatedScene;

  BridgIt bg1;
  BridgIt bg2;
  WorldScene emptyScene1;

  // method to initialize the data
  void initData() {

    this.out20 = new OutsideCell();
    this.cell100 = new Cell(new Posn(20, 20), Color.white, this.out20, this.out20, this.out20,
        this.out20, false);
    this.cell101 = new Cell(new Posn(60, 20), Color.white, this.out20, this.out20, this.out20,
        this.out20, false);

    this.ws20 = new WorldScene(200, 200);
    this.bg20 = new BridgIt(5);

    this.c1 = new Cell(new Posn(220, 180), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c2 = new Cell(new Posn(260, 220), Color.blue, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c3 = new Cell(new Posn(180, 220), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c4 = new Cell(new Posn(220, 260), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c5 = new Cell(new Posn(220, 220), Color.white, c1, c2, c3, c4, false);

    this.emptyScene = new WorldScene(440, 440);
    this.emptyScene1 = new WorldScene(500, 500);
    this.mutatedScene = new WorldScene(440, 440);

    // examples to hand construct a grid list
    this.c6 = new Cell(new Posn(20, 20), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c7 = new Cell(new Posn(60, 20), Color.blue, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c8 = new Cell(new Posn(100, 20), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c9 = new Cell(new Posn(140, 20), Color.blue, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c10 = new Cell(new Posn(180, 20), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c11 = new Cell(new Posn(20, 60), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c12 = new Cell(new Posn(60, 60), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), true);
    this.c13 = new Cell(new Posn(100, 60), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c14 = new Cell(new Posn(140, 60), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), true);
    this.c15 = new Cell(new Posn(180, 60), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c16 = new Cell(new Posn(20, 100), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c17 = new Cell(new Posn(60, 100), Color.blue, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c18 = new Cell(new Posn(100, 100), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), true);
    this.c19 = new Cell(new Posn(140, 100), Color.blue, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c20 = new Cell(new Posn(180, 100), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c21 = new Cell(new Posn(20, 140), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c22 = new Cell(new Posn(60, 140), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), true);
    this.c23 = new Cell(new Posn(100, 140), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c24 = new Cell(new Posn(140, 140), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), true);
    this.c25 = new Cell(new Posn(180, 140), Color.green, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c26 = new Cell(new Posn(20, 180), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c27 = new Cell(new Posn(60, 180), Color.blue, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c28 = new Cell(new Posn(100, 180), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c29 = new Cell(new Posn(140, 180), Color.blue, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);
    this.c30 = new Cell(new Posn(180, 180), Color.white, new OutsideCell(), new OutsideCell(),
        new OutsideCell(), new OutsideCell(), false);

    this.madeList = new ArrayList<ArrayList<ICell>>(
        Arrays.asList(new ArrayList<ICell>(Arrays.asList(c6, c7, c8, c9, c10)),
            new ArrayList<ICell>(Arrays.asList(c11, c12, c13, c14, c15)),
            new ArrayList<ICell>(Arrays.asList(c16, c17, c18, c19, c20)),
            new ArrayList<ICell>(Arrays.asList(c21, c22, c23, c24, c25)),
            new ArrayList<ICell>(Arrays.asList(c26, c27, c28, c29, c30))));

    this.bg1 = new BridgIt(11);
    this.bg2 = new BridgIt(5);

  }

  // tests for makeCellList method
  void testMakeCellList(Tester t) {
    this.initData();
    BridgIt game1 = new BridgIt(5);
    game1.cells = new ArrayList<ArrayList<ICell>>();
    game1.makeCellList();
    t.checkExpect(game1.cells, this.madeList);
  }

  // tests for linkCell method
  void testLinkCells(Tester t) {
    this.initData();
    BridgIt game2 = new BridgIt(5);
    game2.cells = this.madeList;
    game2.linkCells();

    t.checkExpect(this.c6.right, this.c7);
    t.checkExpect(this.c6.bottom, this.c11);
    t.checkExpect(this.c6.left, new OutsideCell());
    t.checkExpect(this.c6.top, new OutsideCell());

    t.checkExpect(this.c10.right, new OutsideCell());
    t.checkExpect(this.c10.bottom, this.c15);
    t.checkExpect(this.c10.left, this.c9);
    t.checkExpect(this.c10.top, new OutsideCell());

    t.checkExpect(this.c26.right, this.c27);
    t.checkExpect(this.c26.bottom, new OutsideCell());
    t.checkExpect(this.c26.left, new OutsideCell());
    t.checkExpect(this.c26.top, this.c21);

    t.checkExpect(this.c30.right, new OutsideCell());
    t.checkExpect(this.c30.bottom, new OutsideCell());
    t.checkExpect(this.c30.left, this.c29);
    t.checkExpect(this.c30.top, this.c25);

    t.checkExpect(this.c8.right, this.c9);
    t.checkExpect(this.c8.bottom, this.c13);
    t.checkExpect(this.c8.left, this.c7);
    t.checkExpect(this.c8.top, new OutsideCell());

    t.checkExpect(this.c16.right, this.c17);
    t.checkExpect(this.c16.bottom, this.c21);
    t.checkExpect(this.c16.left, new OutsideCell());
    t.checkExpect(this.c16.top, this.c11);

    t.checkExpect(this.c28.right, this.c29);
    t.checkExpect(this.c28.bottom, new OutsideCell());
    t.checkExpect(this.c28.left, this.c27);
    t.checkExpect(this.c28.top, this.c23);

    t.checkExpect(this.c20.right, new OutsideCell());
    t.checkExpect(this.c20.bottom, this.c25);
    t.checkExpect(this.c20.left, this.c19);
    t.checkExpect(this.c20.top, this.c15);

    t.checkExpect(this.c18.right, this.c19);
    t.checkExpect(this.c18.bottom, this.c23);
    t.checkExpect(this.c18.left, this.c17);
    t.checkExpect(this.c18.top, this.c13);
  }

  // test methods for drawAt
  void testDrawAt(Tester t) {
    this.initData();
    this.mutatedScene.placeImageXY(this.c5.drawCell(), 220, 220);
    t.checkExpect(this.c5.drawAt(this.emptyScene), this.mutatedScene);

    this.mutatedScene.placeImageXY(this.c1.drawCell(), 220, 180);
    t.checkExpect(this.c1.drawAt(this.emptyScene), this.mutatedScene);

    t.checkException(new RuntimeException("Cannot draw an Outside Cell"), this.out20, "drawAt",
        this.ws20);

  }

  // tests for drawCell method
  void testDrawCell(Tester t) {
    this.initData();
    t.checkExpect(this.c1.drawCell(), new RectangleImage(40, 40, OutlineMode.SOLID, Color.white));
    t.checkExpect(this.c2.drawCell(), new RectangleImage(40, 40, OutlineMode.SOLID, Color.blue));
    t.checkExpect(this.c3.drawCell(), new RectangleImage(40, 40, OutlineMode.SOLID, Color.green));
    t.checkExpect(this.c4.drawCell(), new RectangleImage(40, 40, OutlineMode.SOLID, Color.green));
    t.checkExpect(this.c5.drawCell(), new RectangleImage(40, 40, OutlineMode.SOLID, Color.white));

    t.checkException(new RuntimeException("Cannot draw an Outside Cell"), this.out20, "drawCell");

  }

  // tests for onMouseReleased
  void testOnMouseReleased(Tester t) {
    this.initData();
    BridgIt game3 = new BridgIt(5);
    game3.cells = this.madeList;
    game3.onMouseReleased(new Posn(60, 60));
    t.checkExpect(game3.playerTurn, false);
    t.checkExpect(this.c12.color, Color.green);
    t.checkExpect(this.c12.editable, false);

    this.initData();
    BridgIt game4 = new BridgIt(5);
    game4.cells = this.madeList;
    game4.onMouseReleased(new Posn(20, 20));
    t.checkExpect(game4.playerTurn, true);
    t.checkExpect(this.c6.color, Color.white);
    t.checkExpect(this.c6.editable, false);

  }

  // tests for worldEnds
  void testWorldEnds(Tester t) {
    this.initData();
    BridgIt game4 = new BridgIt(5);
    game4.cells = this.madeList;
    game4.linkCells();
    this.c12.color = Color.green;
    this.c14.color = Color.green;
    t.checkExpect(game4.worldEnds(), new WorldEnd(true, game4.makeAFinalScene("Green Wins!")));

    this.initData();
    BridgIt game5 = new BridgIt(5);
    game5.cells = this.madeList;
    game5.linkCells();
    this.c12.color = Color.blue;
    this.c22.color = Color.blue;
    t.checkExpect(game5.worldEnds(), new WorldEnd(true, game5.makeAFinalScene("Blue Wins!")));

    this.initData();
    BridgIt game6 = new BridgIt(5);
    game6.cells = this.madeList;
    game6.linkCells();
    t.checkExpect(game6.worldEnds(), new WorldEnd(false, game6.makeScene()));

  }

  // tests for makeAFinalScene
  void testMakeAFinalScene(Tester t) {
    this.initData();
    this.emptyScene.placeImageXY(new TextImage("Green Wins!", 44, Color.black), 220, 220);
    t.checkExpect(this.bg1.makeAFinalScene("Green Wins!"), this.emptyScene);
    this.initData();
    this.emptyScene.placeImageXY(new TextImage("Blue Wins!", 44, Color.black), 220, 220);
    t.checkExpect(this.bg1.makeAFinalScene("Blue Wins!"), this.emptyScene);
  }

  // tests for isClicked
  void testIsClicked(Tester t) {
    this.initData();
    t.checkExpect(this.c12.isClicked(new Posn(60, 60)), true);
    this.initData();
    t.checkExpect(this.c12.isClicked(new Posn(60, 81)), false);
    this.initData();
    t.checkExpect(this.c18.isClicked(new Posn(100, 100)), true);
    this.initData();
    t.checkExpect(this.c18.isClicked(new Posn(20, 20)), false);
    this.initData();
    t.checkExpect(this.c18.isClicked(new Posn(110, 95)), true);
    this.initData();
    t.checkException(new RuntimeException("Outside Cell can't be clicked"), this.out20, "isClicked",
        new Posn(20, 20));

  }

  // tests for updateGameState
  void testUpdateGameState(Tester t) {
    this.initData();
    t.checkExpect(this.c6.updateGameState(true), true);
    this.initData();
    t.checkExpect(this.c12.updateGameState(true), false);
    t.checkExpect(this.c12.color, Color.green);
    t.checkExpect(this.c12.editable, false);

    this.initData();
    t.checkExpect(this.c14.updateGameState(false), true);
    t.checkExpect(this.c14.color, Color.blue);
    t.checkExpect(this.c14.editable, false);

    this.initData();
    t.checkExpect(this.c13.updateGameState(true), true);
    t.checkExpect(this.c13.color, Color.green);
    t.checkExpect(this.c13.editable, false);

    this.initData();
    t.checkException(new RuntimeException("Outside Cell has no color"), this.out20,
        "updateGameState", true);

  }

  // tests for updateCell
  void testUpdateCell(Tester t) {
    this.initData();
    this.c12.updateCell(true);
    t.checkExpect(this.c12.color, Color.green);
    t.checkExpect(this.c12.editable, false);

    this.initData();
    this.c12.updateCell(false);
    t.checkExpect(this.c12.color, Color.blue);
    t.checkExpect(this.c12.editable, false);

    this.initData();
    this.c14.updateCell(true);
    t.checkExpect(this.c14.color, Color.green);
    t.checkExpect(this.c14.editable, false);

    this.initData();
    this.c14.updateCell(false);
    t.checkExpect(this.c14.color, Color.blue);
    t.checkExpect(this.c14.editable, false);

    this.initData();
    t.checkException(new RuntimeException("Cannot change an Outside Cell"), this.out20,
        "updateCell", true);
  }

  // tests constructor exception for BridgIt class
  void testBridgItConstructorException(Tester t) {
    t.checkConstructorException(new IllegalArgumentException("invalid board size"), "BridgIt", 0);
    t.checkConstructorException(new IllegalArgumentException("invalid board size"), "BridgIt", 1);
    t.checkConstructorException(new IllegalArgumentException("invalid board size"), "BridgIt", 2);
    t.checkConstructorException(new IllegalArgumentException("invalid board size"), "BridgIt", 4);
    t.checkConstructorException(new IllegalArgumentException("invalid board size"), "BridgIt", 12);
  }

  // tests method makeScene in BridgIt
  void testMakeScene(Tester t) {
    this.initData();
    this.ws20.placeImageXY(this.madeList.get(0).get(0).drawCell(), 20, 20);
    this.ws20.placeImageXY(this.madeList.get(0).get(1).drawCell(), 60, 20);
    this.ws20.placeImageXY(this.madeList.get(0).get(2).drawCell(), 100, 20);
    this.ws20.placeImageXY(this.madeList.get(0).get(3).drawCell(), 140, 20);
    this.ws20.placeImageXY(this.madeList.get(0).get(4).drawCell(), 180, 20);
    this.ws20.placeImageXY(this.madeList.get(1).get(0).drawCell(), 20, 60);
    this.ws20.placeImageXY(this.madeList.get(1).get(1).drawCell(), 60, 60);
    this.ws20.placeImageXY(this.madeList.get(1).get(2).drawCell(), 100, 60);
    this.ws20.placeImageXY(this.madeList.get(1).get(3).drawCell(), 140, 60);
    this.ws20.placeImageXY(this.madeList.get(1).get(4).drawCell(), 180, 60);
    this.ws20.placeImageXY(this.madeList.get(2).get(0).drawCell(), 20, 100);
    this.ws20.placeImageXY(this.madeList.get(2).get(1).drawCell(), 60, 100);
    this.ws20.placeImageXY(this.madeList.get(2).get(2).drawCell(), 100, 100);
    this.ws20.placeImageXY(this.madeList.get(2).get(3).drawCell(), 140, 100);
    this.ws20.placeImageXY(this.madeList.get(2).get(4).drawCell(), 180, 100);
    this.ws20.placeImageXY(this.madeList.get(3).get(0).drawCell(), 20, 140);
    this.ws20.placeImageXY(this.madeList.get(3).get(1).drawCell(), 60, 140);
    this.ws20.placeImageXY(this.madeList.get(3).get(2).drawCell(), 100, 140);
    this.ws20.placeImageXY(this.madeList.get(3).get(3).drawCell(), 140, 140);
    this.ws20.placeImageXY(this.madeList.get(3).get(4).drawCell(), 180, 140);
    this.ws20.placeImageXY(this.madeList.get(4).get(0).drawCell(), 20, 180);
    this.ws20.placeImageXY(this.madeList.get(4).get(1).drawCell(), 60, 180);
    this.ws20.placeImageXY(this.madeList.get(4).get(2).drawCell(), 100, 180);
    this.ws20.placeImageXY(this.madeList.get(4).get(3).drawCell(), 140, 180);
    this.ws20.placeImageXY(this.madeList.get(4).get(4).drawCell(), 180, 180);
    t.checkExpect(this.bg20.makeScene(), this.ws20);
  }

  // tests for updateNeighbor method
  void testUpdateNeighbor(Tester t) {
    this.initData();
    this.cell100.updateNeighbor(this.cell101, "top");
    t.checkExpect(this.cell100.top, this.cell101);

    this.initData();
    this.cell100.updateNeighbor(this.cell101, "bottom");
    t.checkExpect(this.cell100.bottom, this.cell101);

    this.initData();
    this.cell100.updateNeighbor(this.cell101, "right");
    t.checkExpect(this.cell100.right, this.cell101);

    this.initData();
    this.cell100.updateNeighbor(this.cell101, "left");
    t.checkExpect(this.cell100.left, this.cell101);

    t.checkException(new RuntimeException("Outside Cell has no neighbor"), this.out20,
        "updateNeighbor", this.c6, "Top");
  }

  // tests method foundPath in BridgIt
  void testFoundPath(Tester t) {
    this.initData();
    this.bg20.cells = this.madeList;
    this.bg20.linkCells();
    t.checkExpect(this.bg20.foundPath("g"), false);
    t.checkExpect(this.bg20.foundPath("b"), false);

    this.c12.color = Color.green;
    this.c14.color = Color.blue;
    t.checkExpect(this.bg20.foundPath("g"), false);
    t.checkExpect(this.bg20.foundPath("b"), false);

    this.c14.color = Color.green;
    t.checkExpect(this.bg20.foundPath("g"), true);
    t.checkExpect(this.bg20.foundPath("b"), false);

    this.c14.color = Color.blue;
    this.c18.color = Color.blue;
    this.c22.color = Color.blue;
    t.checkExpect(this.bg20.foundPath("g"), false);
    t.checkExpect(this.bg20.foundPath("b"), true);
  }

  // tests method winningPath in ICell
  void testWinningPath(Tester t) {
    this.initData();
    this.bg20.cells = this.madeList;
    this.bg20.linkCells();

    t.checkException(new RuntimeException("Cannot start a winning path from an Outside Cell"),
        this.out20, "winningPath", this.bg20.sideLength, "g");
    t.checkException(new RuntimeException("Cannot start a winning path from an Outside Cell"),
        this.out20, "winningPath", this.bg20.sideLength, "b");

    t.checkExpect(this.c11.winningPath(this.bg20.sideLength, "g"), false);
    t.checkExpect(this.c9.winningPath(this.bg20.sideLength, "b"), false);

    this.c12.color = Color.green;
    this.c14.color = Color.blue;
    t.checkExpect(this.c11.winningPath(this.bg20.sideLength, "g"), false);
    t.checkExpect(this.c9.winningPath(this.bg20.sideLength, "b"), false);

    this.c18.color = Color.green;
    this.c24.color = Color.green;
    t.checkExpect(this.c11.winningPath(this.bg20.sideLength, "g"), true);

    this.c14.color = Color.blue;
    this.c18.color = Color.blue;
    this.c22.color = Color.blue;
    t.checkExpect(this.c9.winningPath(this.bg20.sideLength, "b"), true);
  }

  // tests method isWin in ICell
  void testIsWin(Tester t) {
    this.initData();
    this.bg20.cells = this.madeList;
    this.bg20.linkCells();

    t.checkException(new RuntimeException("Cannot end a winning path on an Outside Cell"),
        this.out20, "isWin", this.bg20.sideLength, "g");
    t.checkException(new RuntimeException("Cannot end a winning path on an Outside Cell"),
        this.out20, "isWin", this.bg20.sideLength, "b");

    t.checkExpect(this.c11.isWin(this.bg20.sideLength, "g"), false);
    t.checkExpect(this.c11.isWin(this.bg20.sideLength, "b"), false);
    t.checkExpect(this.c23.isWin(this.bg20.sideLength, "g"), false);
    t.checkExpect(this.c19.isWin(this.bg20.sideLength, "b"), false);
    t.checkExpect(this.c25.isWin(this.bg20.sideLength, "g"), true);
    t.checkExpect(this.c27.isWin(this.bg20.sideLength, "b"), true);
  }

  // tests method neighbors in ICell
  void testNeighbors(Tester t) {
    this.initData();
    this.bg20.cells = this.madeList;
    this.bg20.linkCells();
    t.checkException(new RuntimeException("Outside Cell has no neighbors"), this.out20, "neighbors",
        "g");
    t.checkException(new RuntimeException("Outside Cell has no neighbors"), this.out20, "neighbors",
        "b");
    t.checkExpect(this.c11.neighbors("g"), new ArrayList<ICell>());
    t.checkExpect(this.c9.neighbors("b"), new ArrayList<ICell>());

    this.c12.color = Color.green;
    t.checkExpect(this.c11.neighbors("g"), new ArrayList<ICell>(Arrays.asList(this.c12)));

    this.c14.color = Color.blue;
    t.checkExpect(this.c9.neighbors("b"), new ArrayList<ICell>(Arrays.asList(this.c14)));

    this.c8.color = Color.green;
    this.c14.color = Color.green;
    this.c18.color = Color.green;
    t.checkExpect(this.c13.neighbors("g"),
        new ArrayList<ICell>(Arrays.asList(this.c8, this.c18, this.c14, this.c12)));

    this.c14.color = Color.blue;
    this.c24.color = Color.blue;
    this.c18.color = Color.blue;
    this.c20.color = Color.blue;
    t.checkExpect(this.c19.neighbors("b"),
        new ArrayList<ICell>(Arrays.asList(this.c14, this.c24, this.c20, this.c18)));
  }

  // tests method sameColor in ICell
  void testSameColor(Tester t) {
    this.initData();
    t.checkExpect(this.out20.sameColor("g"), false);
    t.checkExpect(this.out20.sameColor("b"), false);
    t.checkExpect(this.c12.sameColor("g"), false);
    t.checkExpect(this.c12.sameColor("b"), false);
    t.checkExpect(this.c13.sameColor("g"), true);
    t.checkExpect(this.c19.sameColor("b"), true);
  }

  // Call Big Bang
  void testGame(Tester t) {
    BridgIt game = new BridgIt(11);
    game.bigBang(game.width, game.height, .1);
  }

}