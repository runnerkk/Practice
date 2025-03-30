package kh.gangnam.movie.Model.OpenApiDAO;

import jakarta.persistence.*;
import kh.gangnam.movie.Model.OpenApiDTO.DailyBoxOffice;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class DailyBoxOfficeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rnum;
    private String dailyRank;
    private String rankInten;
    private String movieNm;
    private String openDt;
    private String salesAmt;
    private String salesAcc;
    private String audiAcc;
    private String scrnCnt;
    private String showCnt;

    @ManyToOne
    @JoinColumn(name = "daily_id")
    private BoxOfficeResultDAO boxOfficeResult;

    public static DailyBoxOfficeDAO fromDTO(DailyBoxOffice dto) {
        DailyBoxOfficeDAO dao = new DailyBoxOfficeDAO();
        dao.rnum = dto.getRnum();
        dao.dailyRank = dto.getRank();
        dao.rankInten = dto.getRankInten();
        dao.movieNm = dto.getMovieNm();
        dao.openDt = dto.getOpenDt();
        dao.salesAmt = dto.getSalesAmt();
        dao.salesAcc = dto.getSalesAcc();
        dao.audiAcc = dto.getAudiAcc();
        dao.scrnCnt = dto.getScrnCnt();
        dao.showCnt = dto.getShowCnt();
        return dao;
    }
}
