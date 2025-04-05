
package com.mycompany.laba2.GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomeMessageGUI {

    public static void showWelcomeMessage(JPanel panel, Font font, Color col) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel welcome = new JLabel("<html><div style='text-align: center;'>"
                + "<h1>Темные Хроники: Сбор Армии Саурона</h1>"
                + "<p><i>Тени сгущаются над Средиземьем. </i></p>"
                + "<p><i>Великий Тёмный Властелин Саурон готовится к последней битве, </i></p>"
                + "<p><i>что решит судьбу всех земель. Но даже его могущества недостаточно — </i></p>"
                + "<p><i>ему нужна армия, достойная его власти.</i></p></div>"
                + "<div style='text-align: left;'>"
                + "<p></p>"
                + "<p><b>Ваша миссия: </b></p>"
                + "<p><i>Вы — верховный военачальник Мордора, и от ваших решений зависит </i></p>"
                + "<p><i>исход грядущей войны. Саурон поручил вам собрать несокрушимую орду из </i></p>"
                + "<p><i>орков разных племен.</i></p>"
                + "<p></p>"
                + "<p><b>Как действовать?</b></p>"
                + "<p><b>• Выберите племя</b> — определите, какие орки лучше подойдут для вашей стратегии.</p>"
                + "<p><b>• Выберите тип</b> — решите, нужны ли вам командиры для управления или разведчики</p> "
                + "<p>  для скрытных действий</p>"
                + "<p><b>• Соберите армию</b> — комбинируйте разные типы, чтобы создать идеальный баланс силы и тактики.</p>"
                + "<p><b>• Повелите ордой</b> — ведите своих воинов к победе над эльфами, людьми и хоббитами!</p>"
                + "<p></p>"
                + "<p><b>Тьма наступает. Время выбирать — будете ли вы достойным слугой Саурона?</b></p>"
                + "<p></p>"
                + "<p><i>(P.S. Помните: даже оркам нужна дисциплина. Не переборщите с разведчиками — </i></p>"
                + "<p><i>без командиров они быстро разбегутся!)</i></p>"
                + "</div></html>",
                 SwingConstants.CENTER);
        welcome.setFont(font);
        welcome.setForeground(col);

        panel.add(welcome);
    }

}
