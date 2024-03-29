package com.xzy.read.service;

import com.xzy.read.VO.ResultVo;
import com.xzy.read.entity.NoteBooks;

import java.util.List;

/**
 * @author XieZhongYi
 * 2020/03/25 15:06
 */
public interface NoteBooksService {

    ResultVo getAll();

    ResultVo create(NoteBooks noteBooks);

    ResultVo update(NoteBooks noteBooks);

    ResultVo delete(Long id);

    NoteBooks findById(Long id);

    ResultVo getSimpleInfo(Long id);

    ResultVo getArticlesByNbId(Long id, int page);

    List<NoteBooks> findAllByUserId(Long userId);

}
