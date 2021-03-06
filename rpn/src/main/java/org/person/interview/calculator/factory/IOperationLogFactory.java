package org.person.interview.calculator.factory;

import org.person.interview.calculator.operation.IOperationItem;
import org.person.interview.calculator.operation.Operand;
import org.person.interview.calculator.operation.OperationLog;

import java.util.List;

public interface IOperationLogFactory {
    OperationLog create(IOperationItem operation, List<Operand> operands, Operand result);
}
