package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem findItemById(Long id) {
		TbItemExample example = new TbItemExample();
		
		Criteria createCriteria = example.createCriteria();
		
		createCriteria.andIdEqualTo(id);
		
		List<TbItem> list = itemMapper.selectByExample(example);
		
		if(list != null && list.size()>0){
			return list.get(0);
		}
		
		return null;
	}

}
