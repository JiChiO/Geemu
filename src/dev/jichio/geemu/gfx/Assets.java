package dev.jichio.geemu.gfx;

import dev.jichio.geemu.text.TextLoader;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Assets {



    public static BufferedImage playerFront,playerFrontLF,playerFrontRF,playerBack,playerBackLF,playerBackRF, playerLeft,
            playerLeftHF, playerLeftHB, playerRight, playerRightHB, playerRightHF,  mainRoom, train, grass, stone, bed, BB;

    public static void init(){
        //Присваиваем атрибуту player парядковый номер спрайтшита из списка
        BufferedImage b [] = ArrayCrop("/textures/GGs", "png");
        //Присваиваем атрибуту player парядковый номер спрайтшита из списка
        playerFrontLF = b[0];
        playerFront = b[1];
        playerFrontRF = b[2];
        playerBackLF = b[3];
        playerBack = b[4];
        playerBackRF = b[5];
        playerLeftHF = b[6];
        playerLeft = b[7];
        playerLeftHB = b[8];
        playerRightHB = b[9];
        playerRight = b[10];
        playerRightHF = b[11];

        b = ArrayCrop("/textures/MainRoom", "png");
        mainRoom = b[0];

        b = ArrayCrop("/textures/Train", "png");
        train = b[0];

        b = ArrayCrop("/textures/Grass", "png");
        grass = b[0];

        b = ArrayCrop("/textures/Stone", "png");
        stone = b[0];

        b = ArrayCrop("/textures/Bed", "png");
        bed = b[0];

        b = ArrayCrop("/textures/BB", "png");
        BB = b[0];
    }
    //Рабивеам спрайты на массивы
    public static BufferedImage[] ArrayCrop(String s, String res){
        //Загружаем картинку в формате s=имя + res=расширение
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(s + "." + res));
        //Загружаем размеры нарезки и общее кол-во спрайтов из текстового файла
        String[] q = TextLoader.loadText(s + ".txt").split("\\s+");
        //Создаем список спрайтов
        List<BufferedImage> list = new ArrayList<BufferedImage>();
        // Присваиваем по порядку ширину, длину и кол-во спрайтов из файла
        int charwidth = Integer.parseInt(q[0]);
        int charheight = Integer.parseInt(q[1]);
        int charcount = Integer.parseInt(q[2]);

        //Заполняем масив изображенями обходя по строкам
        for (int i = 0; (i < sheet.height()/charheight) && (charcount != 0); i++) {
            for (int j = 0; (j < sheet.widht()/charwidth) && (charcount != 0); j++) {
                //Добовляем в список вырезаные спрайтшиты
                list.add(sheet.crop(j * charwidth, i * charheight, charwidth, charheight));
                //Обратный отсчет кол-ва спрайтшитов
                charcount = charcount - 1;
            }
        }
        //Возвращаем массив преобразоный из списка
        return list.toArray(new BufferedImage[0]);
    }
}
