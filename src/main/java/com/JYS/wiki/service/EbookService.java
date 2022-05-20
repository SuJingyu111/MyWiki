package com.JYS.wiki.service;

import com.JYS.wiki.domain.Ebook;
import com.JYS.wiki.domain.EbookExample;
import com.JYS.wiki.mapper.EbookMapper;
import com.JYS.wiki.req.EbookReq;
import com.JYS.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp resp = new EbookResp();
            BeanUtils.copyProperties(ebook, resp);
            respList.add(resp);
        }
        return respList;
    }
}
