package tech.qianmi.coderetreat.action;

import tech.qianmi.coderetreat.model.IBoard;

public interface IRefresher {
    
    IBoard refresh(IBoard board);
}
