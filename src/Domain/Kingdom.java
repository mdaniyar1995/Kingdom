package Domain;

import Domain.Monsters.Goblin;
import Domain.Monsters.Skeleton;
import Domain.Player.Hero;
import Entity.Character;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kingdom {

    private static BufferedReader br;

    private static Character player = null;

    private static Battle Battle = null;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        Battle = new Battle();

        System.out.println("Введите имя персонажа:");

        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {

        if (player == null) {
            player = new Hero(
                    string,
                    100,
                    20,
                    20,
                    0,
                    0
            );
            System.out.println(String.format("Игрок %s!", player.getName()));

            printNavigation();
        }

        switch (string) {

            case "1": {
                commitFight();
            }
            break;
            case "2":
                System.exit(1);
                break;
            case "да":
                command("1");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }

        command(br.readLine());
    }


    private static void commitFight() {
        Battle.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getExperience(), player.getGold(), player.getHealth()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. В темный лес");
        System.out.println("2. Выход");
    }

    private static Character createMonster() {

        int random = (int) (Math.random() * 10);

        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }

    interface FightCallback {
        void fightWin();

        void fightLost();
    }
}
