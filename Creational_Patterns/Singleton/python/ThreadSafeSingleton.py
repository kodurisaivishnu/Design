import threading

class ThreadSafeSingleton:
  _instance = None
  _lock = threading.Lock()

  def __init__(self):
    if ThreadSafeSingleton._instance is not None:
      raise Exception("There is a singleton instance")

  @classmethod
  def get_instance(cls):
    if cls._instance is None:
      with cls._lock:
        if cls._instance is None:
          cls._instance = ThreadSafeSingleton()
    return cls._instance

ob1 = ThreadSafeSingleton.get_instance()
ob2 = ThreadSafeSingleton.get_instance()

print(ob1 is ob2)