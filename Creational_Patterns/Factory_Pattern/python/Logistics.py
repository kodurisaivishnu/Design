from abc import ABC, abstractmethod
from typing import override

class Logistics(ABC):
  @abstractmethod
  def send(self):
    pass

class Air(Logistics):
  @override
  def send(self):
    print("Sending By air")


class Road(Logistics):
  @override
  def send(self):
    print("Sending By Road")

class LogisticFactory:
  @staticmethod
  def get_logistics(mode):
    if mode.lower() == 'air':
      return Air()
      # logistics = Air()
      # logistics.send() # this is bad we have to have a service
    elif mode.lower() == 'road':
      return Road()
      # logistics = Road()
      # logistics.send() # this is bad we need to have a service
    return None
    
class LogisticsSerivce:
  def send(self, mode):
    logistics = LogisticFactory.get_logistics(mode)
    logistics.send()
  

if __name__ == '__main__':
  service = LogisticsSerivce()
  service.send("road")
