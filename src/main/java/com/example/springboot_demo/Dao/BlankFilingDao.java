package com.example.springboot_demo.Dao;

import com.example.springboot_demo.Modal.BlankFiling;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HFZ
 * @email 1310209619@qq.com
 * @date 2019-07-06 10:53
 */
@Mapper
@Component
public interface BlankFilingDao {
    List<BlankFiling> getBlankFiling();
}
