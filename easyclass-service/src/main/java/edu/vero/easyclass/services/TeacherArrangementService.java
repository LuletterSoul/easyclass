package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Notice;

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
}
