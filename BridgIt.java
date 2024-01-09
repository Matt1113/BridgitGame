import java.util.ArrayList;
import javalib.impworld.*;
import java.awt.Color;
import javalib.worldimages.*;

//represents a BridgIt game
class BridgIt extends World {

  ArrayList<ArrayList<ICell>> cells = new ArrayList<ArrayList<ICell>>();
  int sideLength;
  int width;
  int height;
  boolean playerTurn = true;

  // main constructor for BridgIt
  BridgIt(int sideLength) {
    if (sideLength < 3 || sideLength % 2 == 0) {
      throw new IllegalArgumentException("invalid board size");
    }
    this.sideLength = sideLength;
    this.width = this.sideLength * 40;
    this.height = this.sideLength * 40;
    this.makeCellList();
    this.linkCells();
  }

  // method that constructs 2d array of cells with correct positions and colors
  void makeCellList() {
    for (int i = 0; i < this.sideLength; i++) {
      this.cells.add(new ArrayList<ICell>());
      for (int j = 0; j < this.sideLength; j++) {
        if (i % 2 == 0 && j % 2 == 1) {
          this.cells.get(i).add(new Cell(new Posn(((j * 40) + 20), ((i * 40) + 20)), Color.blue,
              new OutsideCell(), new OutsideCell(), new OutsideCell(), new OutsideCell(), false));
        }
        else if (i % 2 == 1 && j % 2 == 0) {
          this.cells.get(i).add(new Cell(new Posn(((j * 40) + 20), ((i * 40) + 20)), Color.green,
              new OutsideCell(), new OutsideCell(), new OutsideCell(), new OutsideCell(), false));
        }
        else {
          if (i == 0 || i == this.sideLength - 1 || j == 0 || j == this.sideLength - 1) {
            this.cells.get(i).add(new Cell(new Posn(((j * 40) + 20), ((i * 40) + 20)), Color.white,
                new OutsideCell(), new OutsideCell(), new OutsideCell(), new OutsideCell(), false));
          }
          else {
            this.cells.get(i).add(new Cell(new Posn(((j * 40) + 20), ((i * 40) + 20)), Color.white,
                new OutsideCell(), new OutsideCell(), new OutsideCell(), new OutsideCell(), true));
          }
        }
      }
    }
  }

  // method that links neighboring cells depending on board position
  void linkCells() {
    for (int i = 0; i < this.sideLength; i++) {
      for (int j = 0; j < this.sideLength; j++) {
        ICell currentCell = this.cells.get(i).get(j);

        if (j + 1 < this.sideLength) {
          currentCell.updateNeighbor(this.cells.get(i).get(j + 1), "right");
        }
        if (j - 1 >= 0) {
          currentCell.updateNeighbor(this.cells.get(i).get(j - 1), "left");
        }
        if (i + 1 < this.sideLength) {
          currentCell.updateNeighbor(this.cells.get(i + 1).get(j), "bottom");
        }
        if (i - 1 >= 0) {
          currentCell.updateNeighbor(this.cells.get(i - 1).get(j), "top");
        }
      }
    }
  }

  // draws the game
  public WorldScene makeScene() {
    WorldScene ws = new WorldScene(this.width, this.height);
    for (int i = 0; i < this.sideLength; i++) {
      for (int j = 0; j < this.sideLength; j++) {
        this.cells.get(i).get(j).drawAt(ws);
      }
    }
    return ws;
  }

  // when the mouse is clicked, updates the color of the space based on whose turn
  // it is, and then updates whose turn it is
  public void onMouseReleased(Posn pos) {
    for (int i = 0; i < this.sideLength; i++) {
      for (int j = 0; j < this.sideLength; j++) {
        if (this.cells.get(i).get(j).isClicked(pos)) {
          this.playerTurn = this.cells.get(i).get(j).updateGameState(this.playerTurn);
        }
      }
    }
  }

  // ends the game if a player has made a path across the board
  // otherwise, the game continues
  public WorldEnd worldEnds() {
    if (this.foundPath("g")) {
      return new WorldEnd(true, this.makeAFinalScene("Green Wins!"));
    }
    else if (this.foundPath("b")) {
      return new WorldEnd(true, this.makeAFinalScene("Blue Wins!"));
    }
    else {
      return new WorldEnd(false, this.makeScene());
    }
  }

  // is there a path of green cells or blue cells from one edge of the board to
  // the other?
  boolean foundPath(String col) {
    boolean won = false;
    for (int i = 1; i < this.sideLength - 1; i = i + 2) {
      if (col.equals("g")) {
        won = won || this.cells.get(i).get(0).winningPath(this.sideLength, col);
      }
      else {
        won = won || this.cells.get(0).get(i).winningPath(this.sideLength, col);
      }
    }
    return won;
  }

  // produces a new winning world scene based in the given color
  public WorldScene makeAFinalScene(String col) {
    WorldScene ws = new WorldScene(this.sideLength * 40, this.sideLength * 40);
    ws.placeImageXY(new TextImage(col, this.sideLength * 4, Color.black), this.height / 2,
        this.width / 2);
    return ws;
  }
}

//represents an ICell
interface ICell {

  // Updates the top, bottom, right, or left of this ICell to be the given ICell
  // according to the given string
  void updateNeighbor(ICell cell, String neighbor);

  // Draws a cell at the position of the cell
  WorldScene drawAt(WorldScene background);

  // draws a cell
  WorldImage drawCell();

  // determines if this cell is the cell that was clicked
  boolean isClicked(Posn pos);

  // updates whose turn it is and calls the methods to update a cell
  boolean updateGameState(boolean playerTurn);

  // update the color of a cell and makes it not editable because its been clicked
  void updateCell(boolean playerTurn);

  // does this ICell connect to the other edge of the board of given sideLength
  // according to the given string color
  boolean winningPath(int sideLength, String col);

  // is this ICell on the winning edge according to the given string and given
  // sideLength of the game board
  boolean isWin(int sideLength, String col);

  // produces an ArrayList of ICells that are direct neighbors of this ICell
  // the neighbors must be the color according to the given string
  ArrayList<ICell> neighbors(String col);

  // is this ICell the color according to the given string
  boolean sameColor(String col);
}

//represents an OutsideCell
class OutsideCell implements ICell {

  // OutsideCell not drawable
  public WorldScene drawAt(WorldScene background) {
    throw new RuntimeException("Cannot draw an Outside Cell");
  }

  // OutsideCell not drawable
  public WorldImage drawCell() {
    throw new RuntimeException("Cannot draw an Outside Cell");
  }

  // no neighbor to update of an OutsideCell
  public void updateNeighbor(ICell cell, String neighbor) {
    throw new RuntimeException("Outside Cell has no neighbor");
  }

  // outside cells cant be clicked
  public boolean isClicked(Posn pos) {
    throw new RuntimeException("Outside Cell can't be clicked");
  }

  // outside cells cant be updated
  public boolean updateGameState(boolean playerTurn) {
    throw new RuntimeException("Outside Cell has no color");
  }

  // cannot change an outside cell
  public void updateCell(boolean playerTurn) {
    throw new RuntimeException("Cannot change an Outside Cell");
  }

  // OutsideCell cannot start a winning path
  public boolean winningPath(int sideLength, String col) {
    throw new RuntimeException("Cannot start a winning path from an Outside Cell");
  }

  // OutsideCell cannot be on a winning edge
  public boolean isWin(int sideLength, String col) {
    throw new RuntimeException("Cannot end a winning path on an Outside Cell");
  }

  // Outside Cell has no neighbors
  public ArrayList<ICell> neighbors(String col) {
    throw new RuntimeException("Outside Cell has no neighbors");
  }

  // is this OutisdeCell the color according to the given string
  public boolean sameColor(String col) {
    return false;
  }

}

//Class to represent a cell 
class Cell implements ICell {

  // cell position on board
  Posn pos;
  // cell color
  Color color;
  // cell above
  ICell top;
  // cell right
  ICell right;
  // cell left
  ICell left;
  // cell bottom
  ICell bottom;

  boolean editable;

  // main constructor for Cell
  Cell(Posn pos, Color color, ICell top, ICell right, ICell left, ICell bottom, boolean editable) {
    this.pos = pos;
    this.color = color;
    this.top = top;
    this.right = right;
    this.left = left;
    this.bottom = bottom;
    this.editable = editable;
  }

  // Updates the top, bottom, right, or left of this Cell to be the given ICell
  // according to the given string
  public void updateNeighbor(ICell cell, String neighbor) {
    if (neighbor.equals("top")) {
      this.top = cell;
    }
    else if (neighbor.equals("bottom")) {
      this.bottom = cell;
    }
    else if (neighbor.equals("right")) {
      this.right = cell;
    }
    else if (neighbor.equals("left")) {
      this.left = cell;
    }
  }

  // Draws a cell at the position of the cell
  public WorldScene drawAt(WorldScene background) {
    background.placeImageXY(this.drawCell(), this.pos.x, this.pos.y);
    return background;

  }

  // draws a cell
  public WorldImage drawCell() {
    return new RectangleImage(40, 40, OutlineMode.SOLID, this.color);
  }

  // determines if this cell is the cell that was clicked
  public boolean isClicked(Posn pos) {
    return (Math.abs(pos.x - this.pos.x) <= 20) && (Math.abs(pos.y - this.pos.y) <= 20);
  }

  // updates whose turn it is and calls the methods to update a cell
  public boolean updateGameState(boolean playerTurn) {
    if (this.editable) {
      this.updateCell(playerTurn);
      return !playerTurn;
    }
    else {
      return playerTurn;
    }
  }

  // update the color of a cell and makes it not editable because its been clicked
  public void updateCell(boolean playerTurn) {
    if (playerTurn) {
      this.color = Color.green;
      this.editable = false;
    }
    else {
      this.color = Color.blue;
      this.editable = false;
    }
  }

  // does this Cell connect to the other edge of the board of given sideLength
  // according to the given string color
  public boolean winningPath(int sideLength, String col) {
    ArrayList<ICell> worklist = new ArrayList<ICell>();
    ArrayList<ICell> alreadySeen = new ArrayList<ICell>();
    worklist.add(this);
    while (!worklist.isEmpty()) {
      ICell next = worklist.remove(0);
      if (next.isWin(sideLength, col)) {
        return true;
      }
      else if (alreadySeen.contains(next)) {
        // do nothing: we've already seen this one
      }
      else {
        for (ICell gn : next.neighbors(col)) {
          worklist.add(gn);
        }
        alreadySeen.add(next);
      }
    }
    return false;
  }

  // is this Cell on the winning edge according to the given string color and
  // given
  // sideLength of the game board
  public boolean isWin(int sideLength, String col) {
    if (col.equals("g")) {
      return this.pos.x == (sideLength * 40) - 20;
    }
    else {
      return this.pos.y == (sideLength * 40) - 20;
    }
  }

  // produces an ArrayList of ICells that are direct neighbors of this Cell
  // the neighbors must be the color according to the given string
  public ArrayList<ICell> neighbors(String col) {
    ArrayList<ICell> neighbors = new ArrayList<ICell>();
    if (this.top.sameColor(col)) {
      neighbors.add(this.top);
    }
    if (this.bottom.sameColor(col)) {
      neighbors.add(this.bottom);
    }
    if (this.right.sameColor(col)) {
      neighbors.add(this.right);
    }
    if (this.left.sameColor(col)) {
      neighbors.add(this.left);
    }
    return neighbors;
  }

  // is this Cell the color according to the given string
  public boolean sameColor(String col) {
    if (col.equals("g")) {
      return this.color == Color.green;
    }
    else {
      return this.color == Color.blue;
    }
  }

}