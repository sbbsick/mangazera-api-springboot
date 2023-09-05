package io.mangazera.mangaspringapi.config;

import io.mangazera.mangaspringapi.domain.Author;
import io.mangazera.mangaspringapi.domain.Manga;
import io.mangazera.mangaspringapi.repository.AuthorRepository;
import io.mangazera.mangaspringapi.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {
    private final MangaRepository mangaRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        mangaRepository.deleteAll();
        authorRepository.deleteAll();

        Manga onePiece = new Manga(null, "One Piece", "https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/8132972-100.jpg",
                "One Piece is a Japanese manga series written and illustrated by Eiichiro Oda. It has been serialized in Shueisha's Weekly Shōnen Jump magazine since July 1997, with its individual chapters compiled into 99 tankōbon volumes as of June 2021.", 1010, sdf.parse("22/07/1997"),
                sdf.parse("22/07/2021"), false);

        Manga naruto = new Manga(null, "Naruto", "https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/4424713-69.jpg",
                "Naruto is a Japanese manga series written and illustrated by Masashi Kishimoto. It tells the story of Naruto Uzumaki, a young ninja who seeks recognition from his peers and dreams of becoming the Hokage, the leader of his village.", 700, sdf.parse("21/09/1999"),
                sdf.parse("10/11/2014"), true);

        Manga dragonBall = new Manga(null, "Dragon Ball", "https://comicvine.gamespot.com/a/uploads/scale_large/0/4/45048-7104-52108-1-dragon-ball.jpg",
                "Dragon Ball is a Japanese manga series written and illustrated by Akira Toriyama. It was originally serialized in Weekly Shōnen Jump magazine from 1984 to 1995, with the 519 individual chapters published into 42 tankōbon volumes by Shueisha.", 519, sdf.parse("20/11/1984"),
                sdf.parse("12/04/1995"), true);

        Manga bleach = new Manga(null, "Bleach", "https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/4511768-67.jpg",
                "Bleach is a Japanese manga series written and illustrated by Tite Kubo. Bleach follows the adventures of the hotheaded teenager Ichigo Kurosaki, who inherits his parents' destiny after he obtains the powers of a Soul Reaper.", 686, sdf.parse("05/08/2001"),
                sdf.parse("22/08/2016"), true);

        Manga berserk = new Manga(null, "Berserk", "https://comicvine.gamespot.com/a/uploads/scale_large/11133/111331711/6446305-37%20%D1%82%D0%BE%D0%BC.jpg",
                "Berserk is a Japanese manga series written and illustrated by Kentaro Miura. Set in a medieval Europe-inspired dark fantasy world, the story centers on the characters of Guts, a lone mercenary, and Griffith, the leader of a mercenary band called the Band of the Hawk.", 364, sdf.parse("25/08/1989"),
                null, false);

        Manga hunterXHunter = new Manga(null, "Hunter X Hunter", "https://comicvine.gamespot.com/a/uploads/scale_large/11154/111543828/8061947-27.01.jpg",
                "Hunter × Hunter is a Japanese manga series written and illustrated by Yoshihiro Togashi. It has been serialized in Shueisha's Weekly Shōnen Jump since March 1998, although the manga has frequently gone on extended hiatuses since 2006.", 390, sdf.parse("03/03/1998"),
                sdf.parse("22/08/2016"), true);

        Manga onePunchMan = new Manga(null, "One Punch Man", "https://comicvine.gamespot.com/a/uploads/scale_large/11/110017/8304318-wwww.jpg",
                "Description", 149, sdf.parse("14/06/2012"), null, false);

        Manga hajimeNoIppo = new Manga(null, "Hajime No Ippo", "https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/7777898-128.jpg",
                "Description", 1330, sdf.parse("27/09/1989"), null, false);

        Manga vinlandSaga = new Manga(null, "Vinland Saga", "https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/6751847-19.jpg",
                "Description", 176, sdf.parse("13/04/2005"), null, false);

        Manga gantz = new Manga(null, "Gantz", "https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/5551803-01.jpg",
                "Description", 383, sdf.parse("13/07/2000"), sdf.parse("22/08/2016"), true);

        Manga slamDunk = new Manga(null, "Slam Dunk", "https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/3482353-31.jpg",
                "Description", 276, sdf.parse("08/02/1990"), sdf.parse("22/08/1996"), true);


        mangaRepository.saveAll(List.of(onePiece, naruto, dragonBall, bleach, berserk, hunterXHunter, onePunchMan, hajimeNoIppo, vinlandSaga, gantz, slamDunk));

        Author author1 = new Author(null, "Eiichiro Oda", "https://comicvine.gamespot.com/a/uploads/scale_small/6/67663/8132972-100.jpg", sdf.parse("01/01/1975"), sdf.parse("01/01/1975"));
        Author author2 = new Author(null, "Silas Batista", "https://comicvine.gamespot.com/a/uploads/scale_small/6/67663/8132972-100.jpg", sdf.parse("01/01/1975"), sdf.parse("01/01/1975"));

        author1.getMangas().add(onePiece);
        author2.getMangas().add(onePiece);

        authorRepository.saveAll(List.of(author1, author2));

        onePiece.getAuthors().addAll(List.of(author1,author2));

        mangaRepository.save(onePiece);



    }
}
