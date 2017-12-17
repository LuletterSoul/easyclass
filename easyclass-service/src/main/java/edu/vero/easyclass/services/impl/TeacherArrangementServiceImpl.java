package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.services.TeacherArrangementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  23:04 2017/12/17.
 * @since easyclass
 */

@Service
public class TeacherArrangementServiceImpl implements TeacherArrangementService {
    @Override
    public Notice createNotice(Integer arrangementId, Notice notice) {
        return null;
    }

    @Override
    public List<TeacherArrangement> findAllArrangements() {
        return null;
    }

    @Override
    public List<Courseware> findAllCoursewares(Integer arrangementId) {
        return null;
    }
}
