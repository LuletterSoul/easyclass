package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.TeacherArrangement;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  0:11 2017/12/15.
 * @since easyclass
 */

public interface TeacherArrangementService {

    /**
     *
     * @param arrangementId
     * @param notice
     * @return
     */
    public Notice createNotice(Integer arrangementId,Notice notice);
    public List<TeacherArrangement> findAllArrangements( );
    public List<Courseware> findAllCoursewares(Integer arrangementId);

}
