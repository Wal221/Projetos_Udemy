package Poster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Scanner ler = new Scanner(System.in);
        Comment c1 = new Comment("Have a nice trip! ");
        Comment c2 = new Comment("Wow thast awesomes!" );

        Post p1 = new Post(sdf.parse("21/06/2018 13:05:46"),"Travel to new Zearlar",
               "Im going to visit this wonderful country ", 12 );

         p1.addComment(c1);
         p1.addComment(c2);

        System.out.println(p1);


    }
}
