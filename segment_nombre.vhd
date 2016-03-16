LIBRARY ieee;
USE ieee.std_logic_1164.all;

-- Done
ENTITY segment_nombre IS
PORT(
	C: IN std_logic;
	O: OUT std_logic_vector(0 TO 6)
);
END segment_nombre;

ARCHITECTURE Behavior OF segment_nombre IS
--Signal win: std_logic_vector(0 TO 0);
Signal wout: std_logic_vector(0 TO 6);
BEGIN
	--win <= C;
	with C select
		wout <= 	"0000001" when '0',
					"1001111" when '1';
		O <= wout;
END Behavior;