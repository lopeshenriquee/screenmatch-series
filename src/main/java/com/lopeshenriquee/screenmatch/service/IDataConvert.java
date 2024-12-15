package com.lopeshenriquee.screenmatch.service;

public interface IDataConvert {
    <T> T obterDados(String json, Class<T> classe);
}
