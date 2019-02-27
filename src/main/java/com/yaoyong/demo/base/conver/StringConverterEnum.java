package com.yaoyong.demo.base.conver;

import java.io.IOException;

import com.baomidou.springboot.entity.enums.AgeEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StringConverterEnum extends JsonDeserializer<AgeEnum> {
	@Override
	public AgeEnum deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try {
			final Integer jsonValue = parser.getIntValue();
			System.out.println("----------------3-----------------");

			for (final AgeEnum enumValue : AgeEnum.values()) {
				System.out.println("---------------------------------" + enumValue.getDesc() + enumValue.getValue()
						+ "----" + jsonValue);

				if (enumValue.getValue() == jsonValue) {
					return enumValue;
				}
			}
			System.out.println("----------------4-----------------");

			return AgeEnum.ONE;
		} catch (Exception e) {
			System.out.println("----------------5-----------------");
			return null;
		}
	}
}
