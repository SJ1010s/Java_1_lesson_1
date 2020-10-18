package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int gameMode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;
    private int narrowing;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.finishedGame) {
                    Logic.humanTurn(cellX, cellY);
                    //проверить поледил кто нить или нет


                }

                repaint();
            }
        });

    }

    public void startNewGame(int gameMode, int fieldSize, int winningLength) {
        this.gameMode = gameMode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;
        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
            }
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }

        }


    }

    void drawX(Graphics g, int x, int y) {
        narrowing = (cellWidth + cellHeight) / 10;
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawLine(x * cellWidth + narrowing, y * cellHeight + narrowing,
                (x + 1) * cellWidth - narrowing, (y + 1) * cellHeight - narrowing);
        g.drawLine((x + 1) * cellWidth - narrowing, y * cellHeight + narrowing,
                x * cellWidth + narrowing, (y + 1) * cellHeight - narrowing);
    }

    void drawO(Graphics g, int x, int y) {
        narrowing = (cellWidth + cellHeight) / 10;
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawOval(x * cellWidth + narrowing, y * cellHeight + narrowing,
                cellWidth - narrowing*2, cellHeight - narrowing*2);
    }

}
