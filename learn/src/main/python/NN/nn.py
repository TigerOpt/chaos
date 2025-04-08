import torch
import torch.nn as nn

model = nn.Sequential(
    nn.Linear(3,20),
    nn.ReLU(),
    nn.Linear(20,2)
)

print(model)


def fnn(input):
    ### WRITE YOUR ANSWER HERE
    model = nn.Sequential(
        nn.Linear(10,128),
        nn.ReLU(),
        nn.Linear(128,64),
        nn.ReLU(),
        nn.Linear(64,2)
    )

    criterion = torch.nn.MSELoss()
    optimizer = torch.optim.SGD(model.parameters(), lr=0.1)
    outputs = model(input)

    pass

class Model(nn.Module):
    def __init__(self):
        super(Model,self).__init__()
        self.linear1 = nn.Linear(2,3)
        self.linear2 = nn.Linear(3,2)
    
    def forward(self, x):
        h = torch.sigmoid(self.linear1(x))
        o = torch.sigmoid(self.linear2(h))
        torch.softmax()
        return o
    
model = Model()
X = torch.randn((1,5))
Y = model.forward(X)