
import cv2
import mediapipe as mp 
import pyautogui

mp_drawing = mp.solutions.drawing_utils
mp_hands = mp.solutions.hands

cap = cv2.VideoCapture(0)
hands = mp_hands.Hands()

mouse_control = True  # Variable de control para el control del cursor del ratón

while True:
    ret, image = cap.read()

    if not ret:
        continue

    image = cv2.cvtColor(cv2.flip(image, 1), cv2.COLOR_BGR2RGB)
    results = hands.process(image)

    # Cambia la región de interés (ROI) para cubrir toda la imagen
    if results.multi_hand_landmarks:
        for hand_landmarks in results.multi_hand_landmarks:
            fingers_raised = 0

            finger_tips = [mp_hands.HandLandmark.INDEX_FINGER_TIP, mp_hands.HandLandmark.MIDDLE_FINGER_TIP,
                           mp_hands.HandLandmark.RING_FINGER_TIP, mp_hands.HandLandmark.PINKY_TIP]

            for tip in finger_tips:
                tip_dist = hand_landmarks.landmark[tip].y - hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_PIP].y
                if tip_dist < 0.05:  # Ajusta este valor según la apertura deseada del dedo
                    fingers_raised += 1

                x, y = int(hand_landmarks.landmark[tip].x * image.shape[1]), int(hand_landmarks.landmark[tip].y * image.shape[0])
                cv2.circle(image, (x, y), 5, (0, 0, 255), -1)

            cv2.putText(image, f"Dedos Levantados: {fingers_raised}", (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 2)

            if fingers_raised == 2:
                mouse_control = False
                
            elif fingers_raised == 1:
                mouse_control = True
                # Simular un clic izquierdo del mouse
                pyautogui.click()
            elif fingers_raised == 3:
                mouse_control = True
                # Simular un clic derecho del mouse
                pyautogui.rightClick()
            elif fingers_raised == 4:
                mouse_control = True
                # Simular scroll hacia abajo
                pyautogui.scroll(-150)
            else:
                mouse_control = True
                # Simular scroll hacia arriba
                pyautogui.scroll(150)

    # Comenta o elimina la línea que muestra la cámara en una ventana
    #cv2.imshow('Handtracker', cv2.cvtColor(image, cv2.COLOR_RGB2BGR))

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
#Sin camara y detecta toda la pantalla
