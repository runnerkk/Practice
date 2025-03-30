package kh.gangnam.movie.Model.OpenApiDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DailyBoxOffice {

    private String rnum;
    private String rank;
    private String rankInten;
    private String movieNm;
    private String openDt;
    private String salesAmt;
    private String salesAcc;
    private String audiAcc;
    private String scrnCnt;
    private String showCnt;
}
