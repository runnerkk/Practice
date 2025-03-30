package kh.gangnam.movie.Model.OpenApiDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoxOfficeResult {
    private String boxofficeType;
    private String showDate;
    private List<DailyBoxOffice> dailyBoxOfficeList;
}
