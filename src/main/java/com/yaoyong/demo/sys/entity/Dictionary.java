package com.yaoyong.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.springboot.entity.enums.AgeEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* @ClassName:  Dictionary
* @Description:
* @author: yaoyong
* @date:   2018年12月5日 下午12:37:17
*
*/

@Data
@TableName("dictionary")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "Dictionary")
public class Dictionary  {

	 	@ApiModelProperty("字典ID")
		@TableId(value = "id", type = IdType.AUTO)
		private Long id;

	 @ApiModelProperty("双亲ID")
	 	private Long pid;

	 @ApiModelProperty("字典层级")
	 	private Integer layer;

	 @ApiModelProperty("字典名称")
	 	private String name;

	 @ApiModelProperty("字典CODE值")
	 	private String code;

	 @ApiModelProperty("字典详细描述")
	 	private String content;

	 @ApiModelProperty("排序")
	 	private Integer sort;

	 @ApiModelProperty("'叶子节点{leaf：0，叶子节点；cate：1，目录节点;}' ")
	 	private AgeEnum isLeaf;

	 @ApiModelProperty("是否启动")
	 	private Integer isEnable;

	 @ApiModelProperty("是否删除")
	 	private Integer isDelete;

	 @ApiModelProperty("商户ID")
	 	private String appid;

	 @ApiModelProperty("乐观锁字段")
	 	private Long version;


}

