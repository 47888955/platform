package com.yaoyong.demo.common.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yaoyong.demo.sys.entity.Dictionary;
import com.yaoyong.demo.sys.service.impl.DictionaryService;

/**
 * 字典均需要加入CACHE
 * 字典解决KV对，获取列表，实体
 * @ClassName: DictionaryUtil
 * @Description:
 * @author: yaoyong
 * @date: 2018年12月19日 下午6:02:01
 *
 */
@Component
@Qualifier("dictionaryUtil")
public final class DictionaryUtil {

	@Autowired
	DictionaryService dictionaryService;
	private static final Logger logger = LoggerFactory.getLogger(DictionaryUtil.class);

	/**
	 * 通过 表名+字段名=code dictionary_is_leaf(小写字母)
	 * dictionaryUtil.getDictList("dictionary_is_leaf");
	 * @Title:getDictList
	 * @Description: 字典调用
	 * @param: code
	 * @return: List<Dict>
	 * @throws
	 *
	 */
	public List<Dict> getDictList(String code) {
		QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<Dictionary>();
		queryWrapper.inSql("pid", "select id from dictionary where code='" + code + "'");
		queryWrapper.orderByAsc("sort");
		List<Dictionary> dictList = dictionaryService.list(queryWrapper);
		List<Dict> volist = new ArrayList<Dict>();
		if (null != dictList) {
			for (Dictionary dictionary : dictList) {
				Dict vo = new Dict();
				vo.setCode(dictionary.getAppid());
				vo.setName(dictionary.getName());
				vo.setSort(dictionary.getSort());
				volist.add(vo);
			}
			return volist;
		}
		return null;
	}

	/**
	 * 通过CODE 获取名称
	 * @Title: getDictName
	 * @Description: 获取名称
	 * @param: @param code
	 * @return @return: String
	 * @throws
	 *
	 */
	public Dict getDictName(String code) {
		QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<Dictionary>();
		queryWrapper.eq("code", code);
		Dictionary dictionary = dictionaryService.getOne(queryWrapper);
		if (null != dictionary) {
			Dict vo = new Dict();
			vo.setCode(dictionary.getAppid());
			vo.setName(dictionary.getName());
			vo.setSort(dictionary.getSort());
			return vo;
		}
		return null;
	}

	/**
	 * 针对数据库存数组
	 *  @Title: getDictNames
	 *  @Description: 数组格式为1,2,3,4
	 *  @param: @param codeArray
	 *  @return: List<Dict>
	 *  @throws
	 *
	 */

	public List<Dict> getDictNames(String codeArray) {

		QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<Dictionary>();
		Set<String> codes = filterString(codeArray);
		logger.info(codes+"---------------------");
		if(null == codes){
			return null;
		}
			Iterator iterator = codes.iterator();
			while(iterator.hasNext()){
				queryWrapper.or().eq("code",iterator.next());
		}

		List<Dictionary> dictList =  dictionaryService.list(queryWrapper);
		if(null == dictList){
			return null;
		}
		List<Dict> volist = new ArrayList<Dict>();
		for (Dictionary dictionary : dictList) {
			Dict vo = new Dict();
			vo.setCode(dictionary.getAppid());
			vo.setName(dictionary.getName());
			vo.setSort(dictionary.getSort());
			volist.add(vo);
		}
		return volist;
	}


/**
 *
 * @Title: filterString
 * @Description:过滤字符
 * @param codeArray
 * @return String
 * @throws
 *
 */
	private Set<String> filterString(String codeArray) {
		if(StringUtils.isBlank(codeArray) || StringUtils.isEmpty(codeArray)){
			return null;
		}
		String[] cArray = codeArray.split(",");
		Set<String> hashSet  =  new HashSet<String>();
		for(String tmp : cArray){
			hashSet.add(tmp.trim().toLowerCase());
		}

//		hashSet.add("t");
//		hashSet.add("m");
//		hashSet.add("d");

//		Iterator iterate = hashSet.iterator();
//
//		for (int i = 0, j = hashSet.size(); i < j; i++) {
//
//			sb.append(iterate.next());
//			if (i < j - 1) {
//				sb.append("','");
//			}
//		}

		return hashSet;
	}

	/*
	 * 获得字典 从Redis缓存获取 暂时用配置数据
	 */
	public final static String getMap(String dictType, String code) {

		Map<String, String> map = new HashMap<String, String>();
		// 活动面向用户团体
		map.put("actGroup0", "渠道商");
		System.out.println("--------------活动面向用户团体------------");
		map.put("actGroup1", "C端客户");
		map.put("actGroup", "");

		// 媒体类型media
		// 0视频，1，图片，2文章，3，普通文章；4，广告位文章；5，shop文章；6，帮助类文章

		map.put("media0", "视频");
		map.put("media1", "图片");
		map.put("media2", "文章");
		map.put("media3", "普通文章");
		map.put("media4", "广告位文章");
		map.put("media5", "店铺文章");
		map.put("media6", "帮助文章");

		return map.get(dictType + code);

	}
}
