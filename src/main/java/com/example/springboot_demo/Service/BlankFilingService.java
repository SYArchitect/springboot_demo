package com.example.springboot_demo.Service;

import com.example.springboot_demo.Dao.BlankFilingDao;
import com.example.springboot_demo.Modal.BlankFiling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HFZ
 * @email 1310209619@qq.com
 * @date 2019-07-06 11:04
 */
@Service
public class BlankFilingService {

    @Autowired
    private BlankFilingDao blankFilingDao;

    public List<BlankFiling> getBlankFIling() {
        return blankFilingDao.getBlankFiling();
    }

}
