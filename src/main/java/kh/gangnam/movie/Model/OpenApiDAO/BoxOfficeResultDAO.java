package kh.gangnam.movie.Model.OpenApiDAO;

import jakarta.persistence.*;
import kh.gangnam.movie.Model.OpenApiDTO.BoxOfficeResult;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class BoxOfficeResultDAO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dailyId;
    private String boxofficeType;
    private String showDate;

    @OneToMany(mappedBy = "boxOfficeResult")
    private List<DailyBoxOfficeDAO> dailyBoxOfficeList;

    public static BoxOfficeResultDAO fromDTO(BoxOfficeResult dto) {
        BoxOfficeResultDAO dao = new BoxOfficeResultDAO();
        dao.boxofficeType = dto.getBoxofficeType();

        String original = dto.getShowRange();
        String onlyDate = original.split("~")[0];
        dao.showDate = onlyDate;
        return dao;
    }
}
